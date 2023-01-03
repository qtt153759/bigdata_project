package bigdata_project;

import com.google.gson.GsonBuilder;
import org.apache.kafka.clients.producer.*;
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.ExecutionException;

public class producer {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Properties kafkaProps = new Properties();
        kafkaProps.put("bootstrap.servers", Constants.BROKER);
        kafkaProps.put("key.serializer", io.confluent.kafka.serializers.KafkaAvroSerializer.class);
        kafkaProps.put("value.serializer", io.confluent.kafka.serializers.KafkaAvroSerializer.class);
        kafkaProps.put("schema.registry.url", Constants.SCHEMA_REGISTRY_URL);
        Producer<String, economicIndicatorRecord> producer = new KafkaProducer<String, economicIndicatorRecord>(kafkaProps);
        try {
            for (Topic TOPIC : Constants.TOPICS) {
                String url = "https://www.alphavantage.co/query?function=" + TOPIC.name + "&interval=" + TOPIC.interval + "&apikey=" + Constants.KEY_ALPHAVANTAGE;
                System.out.println(url);
                HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
                connection.setRequestProperty("accept", "application/json");
                connection.setRequestMethod("GET");
                int responseCode = connection.getResponseCode();
                if (responseCode == HttpURLConnection.HTTP_OK) { // success
                    BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                    String inputLine;
                    StringBuffer response = new StringBuffer();
                    while ((inputLine = in.readLine()) != null) {
                        response.append(inputLine);
                    }
                    in.close();

                    // print result
                    System.out.println(responseCode);

                    Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();

                    EconomicIndicator eco_index = gson.fromJson(response.toString(), EconomicIndicator.class);
                    EconomicIndicatorRecord[] index = eco_index.getData();
                    for (int i = 0; i < index.length; i++) {
                        economicIndicatorRecord eiRecord = economicIndicatorRecord.newBuilder()
                                .setDate(index[i].date.getTime()).setValue(index[i].value).setInterval(TOPIC.interval).build();
                        ProducerRecord<String, economicIndicatorRecord> record = new ProducerRecord<>(TOPIC.name, eiRecord);
                        System.out.println(TOPIC.name + " send date " + index[i].date.getTime() + " value " + index[i].value+"interval: "+TOPIC.interval);
                        producer.send(record, new Callback() {
                            @Override
                            public void onCompletion(RecordMetadata metadata, Exception exception) {
                                if (exception == null) {
                                    System.out.println("Success! ");
                                    System.out.println(metadata.toString());
                                }

                            }
                        });
                    }
                } else {
                    System.out.println("GET request did not work.");
                }
                Thread.sleep(60*1000);
            }
            producer.flush();
            producer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
