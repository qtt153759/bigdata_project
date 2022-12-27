package bigdata_project;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;

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
        System.out.println("chay dc");
        Properties kafkaProps = new Properties();
        kafkaProps.put("bootstrap.servers", "localhost:9092,localhost:9092");
        kafkaProps.put("key.serializer", "io.confluent.kafka.serializers.KafkaAvroSerializer");
        kafkaProps.put("value.serializer", "io.confluent.kafka.serializers.KafkaAvroSerializer");
        kafkaProps.put("schema.registry.url", "http://127.0.0.1:8081");
        Producer<String, String> producer = new KafkaProducer<String, String>(kafkaProps);
        try {
            URL url = new URL(
                    "https://www.alphavantage.co/query?function=REAL_GDP&interval=annual&apikey=QDUPH6Q4VXXU16GG");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
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

                Gson gson = new Gson();
                EconomicIndicator real_gdp_index = gson.fromJson(response.toString(), EconomicIndicator.class);
                EconomicIndicatorRecord[] real_gdp = real_gdp_index.getdata();
                System.out.println(real_gdp.toString());
                for (int i = 0; i < real_gdp.length; i++) {
                    System.out.println(real_gdp[i].toString());
                    ProducerRecord<String, String> record = new ProducerRecord<>("news", real_gdp[i].toString());
                    producer.send(record);
                }
            } else {
                System.out.println("GET request did not work.");
            }
            producer.flush();
            producer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
