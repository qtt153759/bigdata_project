package bigdata_project;

import bigdata_project.model.Topic;
import bigdata_project.model.Treasury_yield;
import org.apache.kafka.clients.admin.*;
import org.apache.kafka.streams.processor.To;

import java.time.Duration;
import java.util.*;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        try {

            Properties props = new Properties();
            props.put(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG, Constants.BROKER);
            AdminClient admin = AdminClient.create(props);
            Set<String> topicNames = admin.listTopics().names().get();
            ArrayList<String> TopicNames = new ArrayList<>();
            List<String> batch_topic = Arrays.asList("REAL_GDP", "REAL_GDP_PER_CAPITA", "DURABLES", "CPI"
                    ,"INFLATION","RETAIL_SALES","RETAIL_SALES", "UNEMPLOYMENT","NONFARM_PAYROLL","Treasury_yield");
            List<String> stream_topic=Arrays.asList("EUR_USD_EXCHANGE", "LIVE_TOPICS", "stats_LIVE_TOPICS");
            TopicNames.addAll(batch_topic);
            TopicNames.addAll(stream_topic);
            TopicNames.removeAll(topicNames);
            for (String TOPIC_NAME : TopicNames) {
                CreateTopicsResult newTopic = admin.createTopics(Collections.singletonList(
                        new NewTopic(TOPIC_NAME, 2, (short) (2))));
                if (newTopic.numPartitions(TOPIC_NAME).get() != 2) {
                    System.out.println("Topic has wrong number of partitions.");
                    System.exit(-1);
                }
            }
            admin.close(Duration.ofSeconds(30));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
