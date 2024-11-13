package hello;

import java.util.Properties;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;

public class ProducerClient {
   public static void main(String[] args) {
      Properties props = new Properties();

      props.put("bootstrap.servers", "localhost:9092,localhost:9093,localhost:9094");
      props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
      props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");

      KafkaProducer<String, String> producer = new KafkaProducer<>(props);

      ProducerRecord<String, String> record = new ProducerRecord<>("topic1", "this is a test");

      try {
         producer.send(record);
      } catch (Exception e) {
         e.printStackTrace();
      } finally {
         producer.close();
      }
   }
}
