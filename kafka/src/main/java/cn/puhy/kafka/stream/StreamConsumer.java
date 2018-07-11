package cn.puhy.kafka.stream;

import org.apache.kafka.clients.consumer.*;
import org.apache.kafka.common.PartitionInfo;
import org.apache.kafka.common.TopicPartition;
import org.apache.kafka.common.serialization.StringDeserializer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

/**
 * @author PUHY
 * 2018-07-08 11:00
 */
public class StreamConsumer {

    //kafka集群列表
    private final static String BROKER_LIST = "192.168.47.129:9092,192.168.47.130:9092,192.168.47.131:9092";

    public static void main(String[] args) {
        Properties properties = new Properties();
        properties.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, BROKER_LIST);
        //指定消费组
        properties.put(ConsumerConfig.GROUP_ID_CONFIG, "phy-group");
        //消费者名称
        properties.put(ConsumerConfig.CLIENT_ID_CONFIG, "consumer1");
        //key.serializer    用于反序列化消息KEY的类
        properties.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        //value.serializer  用于反序列化消息VALUE的类
        properties.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        //显示设置偏移量自动提交
        properties.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, true);
        //偏移量提交时间间隔
        properties.put(ConsumerConfig.AUTO_COMMIT_INTERVAL_MS_CONFIG, 1000);

        //实例化KafkaConsumer对象
        KafkaConsumer<String, String> consumer = new KafkaConsumer<>(properties);

        //需要订阅的主题
        List<String> list = new ArrayList<>();
        list.add("phy1");
        //订阅主题
        consumer.subscribe(list);
        //拉取消息
        while (true) {
            ConsumerRecords<String, String> records = consumer.poll(1000);
            for (ConsumerRecord<String, String> record : records) {
                System.out.println(record.key() + "------>" + record.value());
            }
        }
    }
}
