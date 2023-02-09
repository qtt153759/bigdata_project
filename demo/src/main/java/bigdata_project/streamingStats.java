package bigdata_project;

import bigdata_project.serde.JsonDeserializer;
import bigdata_project.serde.JsonSerializer;
import bigdata_project.serde.WrapperSerde;
import bigdata_project.model.Trade;
import bigdata_project.model.TradeStats;

import org.apache.kafka.clients.admin.AdminClient;
import org.apache.kafka.clients.admin.DescribeClusterResult;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.common.utils.Bytes;
import org.apache.kafka.streams.*;
import org.apache.kafka.streams.kstream.*;
import org.apache.kafka.streams.state.WindowStore;

import java.time.Duration;
import java.util.Properties;

import static org.apache.kafka.streams.kstream.Suppressed.BufferConfig.unbounded;
import static org.apache.kafka.streams.kstream.Suppressed.untilWindowCloses;

/**
 * Input is a stream of trades
 * Output is two streams: One with minimum and avg "ASK" price for every 10
 * seconds window
 * Another with the top-3 stocks with lowest minimum ask every minute
 */
public class streamingStats {

    public static void main(String[] args) throws Exception {

        Properties props=new Properties();
        props.put("bootstrap.servers", Constants.BROKER);
        props.put(StreamsConfig.APPLICATION_ID_CONFIG, "stats");
        props.put(StreamsConfig.DEFAULT_KEY_SERDE_CLASS_CONFIG, Serdes.String().getClass().getName());
        props.put(StreamsConfig.DEFAULT_VALUE_SERDE_CLASS_CONFIG, TradeSerde.class.getName());
        props.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");
        // creating an AdminClient and checking the number of brokers in the cluster, so
        // I'll know how many replicas we want...

        AdminClient ac = AdminClient.create(props);
        DescribeClusterResult dcr = ac.describeCluster();
        int clusterSize = dcr.nodes().get().size();
        if (clusterSize < 3)
            props.put("replication.factor", clusterSize);
        else
            props.put("replication.factor", 3);
        StreamsBuilder builder = new StreamsBuilder();
        KStream<String, Trade> source = builder.stream(Constants.LIVE_TOPIC);
        KStream<String, TradeStats> stats = source
                .groupByKey()
                .windowedBy(TimeWindows.of(Duration.ofMinutes(5)).grace(Duration.ofMinutes(0)))
                .<TradeStats>aggregate(() -> new TradeStats(), (k, v, tradestats) -> tradestats.add(v),
                        Materialized.<String, TradeStats, WindowStore<Bytes, byte[]>>as("trade-aggregates")
                                .withKeySerde(Serdes.String()).withValueSerde(new TradeStatsSerde()))
                .suppress(untilWindowCloses(unbounded()))
                .toStream()
                .map((k,v) -> KeyValue.pair(k.window().start()+"-"+k.window().end(), v))
                .mapValues((trade) -> trade.computeAvgPrice());
        stats.to("stats_LIVE_TOPICS",Produced.keySerde(Serdes.String()));
        Topology topology = builder.build();
        KafkaStreams streams = new KafkaStreams(topology, props);
        System.out.println(topology.describe());
        streams.cleanUp();
        streams.start();

        // Add shutdown hook to respond to SIGTERM and gracefully close Kafka Streams
        Runtime.getRuntime().addShutdownHook(new Thread(streams::close));

    }

    static public final class TradeSerde extends WrapperSerde<Trade> {
        public TradeSerde() {
            super(new JsonSerializer<Trade>(), new JsonDeserializer<Trade>(Trade.class));
        }
    }

    static public final class TradeStatsSerde extends WrapperSerde<TradeStats> {
        public TradeStatsSerde() {
            super(new JsonSerializer<TradeStats>(), new JsonDeserializer<TradeStats>(TradeStats.class));
        }
    }

}
