package cn.puhy.kafka;

import org.apache.kafka.clients.producer.Callback;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.Properties;

/**
 * @author PUHY
 * 2018-07-08 9:55
 */
public class Producer {

    //kafka集群列表
    private final static String BROKER_LIST = "192.168.47.129:9092,192.168.47.130:9092,192.168.47.131:9092";

    public static void main(String[] args) {
        Properties properties = new Properties();
        //bootstrap.servers 设置kafka集群列表
        properties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, BROKER_LIST);
        //key.serializer    用于序列化消息KEY的类
        properties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        //value.serializer  用于序列化消息VALUE的类
        properties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        //实例化KafkaProducer对象
        KafkaProducer<String, String> producer = new KafkaProducer<>(properties);

        //实例化ProducerRecord对象，代表一个消息，发送到0分区
        ProducerRecord<String, String> record = new ProducerRecord<>("phy2",0, "phy1", "异步发送消息");
        //异步发送消息
        producer.send(record);

        //同步发送消息
//        record = new ProducerRecord<>("phy1", "phy2", "同步发送消息");
//        producer.send(record).get();

        //回调方法
        Callback callback = (metadata, exception) -> {
            if (exception != null) {
                System.err.println("发送消息失败：" + exception.getStackTrace());
            }
            if (metadata != null) {
                System.out.println("异步方式发送消息结果：" + "topic-" + metadata.topic() + "|partition-"
                        + metadata.partition() + "|offset-" + metadata.offset());
            }
        };
        record = new ProducerRecord<>("phy2",0, "phy3", "回调");
        producer.send(record, callback);

        //发送到1分区
        ProducerRecord<String, String> parRecord = new ProducerRecord<>("phy2",1, "hehe", "指定的分区");
        producer.send(parRecord);

        producer.close();
    }
}
