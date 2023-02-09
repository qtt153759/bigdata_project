package bigdata_project;

import bigdata_project.model.LIVE_INDEX;
import bigdata_project.model.Trade;
import com.google.gson.GsonBuilder;
import org.apache.kafka.clients.producer.*;
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.ExecutionException;

import bigdata_project.serde.JsonSerializer;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class streamingProducer {

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","/home/qtt/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.investing.com/currencies/eur-usd");

        JsonSerializer<Trade> tradeSerializer = new JsonSerializer<>();
        Properties kafkaProps = new Properties();
        kafkaProps.put("bootstrap.servers", Constants.BROKER);
        kafkaProps.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        kafkaProps.put("value.serializer", tradeSerializer.getClass().getName());
        kafkaProps.put("schema.registry.url", Constants.SCHEMA_REGISTRY_URL);
        Producer<String, Trade> producer = new KafkaProducer<String, Trade>(kafkaProps);
        while (true) {
            try {
                for (LIVE_INDEX TOPIC : Constants.STREAMING_TOPICS) {
                        WebElement target=driver.findElement(By.xpath(
                                "//div[@data-test='instrument-header-details']//span[@data-test='instrument-price-last']"));
                        Double value = TOPIC.getValue(target.getText());
                        Trade trade = new Trade(TOPIC.getName(), value);
                        ProducerRecord<String, Trade> record = new ProducerRecord<>(Constants.LIVE_TOPIC,"live", trade);
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
                Thread.sleep(5000);
            } catch (Exception e) {
                e.printStackTrace();
            }

        }


    }
}
