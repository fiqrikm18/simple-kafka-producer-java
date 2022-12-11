package org.example;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.Properties;

/**
 * Hello world!
 *
 */
public class Main 
{
    public static void main( String[] args ) {
        try {
            Properties kafkaProps = new Properties();
            kafkaProps.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "127.0.0.1:9092");
            kafkaProps.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
            kafkaProps.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());

            KafkaProducer<String, String> producer = new KafkaProducer<String, String>(kafkaProps);
            ProducerRecord<String, String> record = new ProducerRecord<>("user_ids", "Biomedical Materials", "ID");
            producer.send(record, new ProducerCallback());
            producer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
