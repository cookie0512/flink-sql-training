package com.xxywebsite;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.xxywebsite.helper.PackageStateMockHelper;
import com.xxywebsite.model.PackageState;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.apache.kafka.common.serialization.ByteArraySerializer;

import java.util.Properties;
import java.util.Random;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * author: xuxiaoyin
 * date:  3/22/2021 12:18 AM
 * description:
 */
@Slf4j
public class MyKafkaProducer {
    private static final String PACKAGE_STATE_TOPIC = "package_state";
    private static final String BROKERS = "localhost:9092";
    private static final String KAFKA_ADDRESS_ENV = "KAFKA_ADDRESS";
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        String brokers = System.getenv(KAFKA_ADDRESS_ENV);
        if (brokers == null || brokers.isEmpty()) {
            System.out.println("请输入环境变量：KAFKA_ADDRESS");
//            log.error("请输入环境变量：KAFKA_ADDRESS");
            return;
        } else {
            System.out.println(String.format("KAFKA_ADDRESS为：%s", brokers));
//            log.info("KAfFA_ADDRESS为：{}", brokers);
        }

        Properties properties = createKafkaProperties(brokers);
        KafkaProducer<byte[], byte[]> kafkaProducer = new KafkaProducer<>(properties);

        Random random = new Random();
        while (true) {
            PackageState packageState = PackageStateMockHelper.mock();
            byte[] value = JSONObject.toJSONBytes(packageState, SerializerFeature.NotWriteDefaultValue);
            ProducerRecord<byte[], byte[]> record = new ProducerRecord<>(PACKAGE_STATE_TOPIC, value);
            Future<RecordMetadata> future = kafkaProducer.send(record);

//            kafkaProducer.flush();
            Thread.sleep(100);
        }

    }

    private static Properties createKafkaProperties(String brokers) {
        Properties kafkaProps = new Properties();
        kafkaProps.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, brokers);
        kafkaProps.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, ByteArraySerializer.class.getCanonicalName());
        kafkaProps.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, ByteArraySerializer.class.getCanonicalName());
        return kafkaProps;
    }
}
