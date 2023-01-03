package bigdata_project;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import io.confluent.kafka.serializers.KafkaAvroDeserializer;
import io.confluent.kafka.serializers.KafkaAvroDeserializerConfig;
import org.apache.kafka.clients.consumer.*;
import java.time.Duration;

import java.util.HashMap;
import java.util.Properties;
import java.util.regex.Pattern;

public class consumer {
    public static void main(String[] args) {
        System.out.println("run consumer");
        Properties kafkaProps = new Properties();
        kafkaProps.put("bootstrap.servers", Constants.BROKER);
        kafkaProps.put(ConsumerConfig.GROUP_ID_CONFIG, "bigdata");
        kafkaProps.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, KafkaAvroDeserializer.class);
        kafkaProps.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, KafkaAvroDeserializer.class);
        kafkaProps.put(KafkaAvroDeserializerConfig.SPECIFIC_AVRO_READER_CONFIG, true);
        kafkaProps.put("schema.registry.url", Constants.SCHEMA_REGISTRY_URL);
        Consumer<String, economicIndicatorRecord> consumer =new KafkaConsumer<String, economicIndicatorRecord>(kafkaProps);
        consumer.subscribe(Pattern.compile("REAL_GDP"));
        Duration timeout = Duration.ofMillis(100);
        HashMap<economicIndicatorRecord,Integer>custCountryMap=new HashMap<>();
        while (true) {
            ConsumerRecords<String, economicIndicatorRecord> records = consumer.poll(timeout);
            for (ConsumerRecord<String, economicIndicatorRecord> record : records) {
                System.out.printf("topic = %s, partition = %d, offset = %d, " +
                                "customer = %s, country = %s\n",
                        record.topic(), record.partition(), record.offset(),
                        record.key(), record.value());
                int updatedCount = 1;
                if (custCountryMap.containsKey(record.value())) {
                    updatedCount = custCountryMap.get(record.value()) + 1;
                }
                custCountryMap.put(record.value(), updatedCount);
                Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
                System.out.println(gson.toJson(custCountryMap));
            }
        }
    }
}
