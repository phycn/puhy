package cn.puhy.kafka;

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
public class Consumer {

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

        //获取所有分区
        List<PartitionInfo> partitionInfoList = consumer.partitionsFor("phy2");
        for (PartitionInfo partitionInfo : partitionInfoList) {
            System.out.println("分区：" + partitionInfo.partition());
        }

        //获取指定分区的消费偏移量
        TopicPartition p1 = new TopicPartition("phy2", 1);
        OffsetAndMetadata offsetAndMetadata = consumer.committed(p1);
        System.out.println("当前偏移量：" + offsetAndMetadata.offset());

        //需要订阅的主题
        List<String> list = new ArrayList<>();
        list.add("phy2");
        //订阅主题
//        consumer.subscribe(list);
        //订阅指定分区，只能拉取这个分区的消息
        consumer.assign(Arrays.asList(p1));

        //重置消费偏移量，可以获取到之前的所有消息
        consumer.seek(p1, 0);
        //暂停某些分区的拉取操作
//        consumer.pause();
        //恢复某些分区的拉取操作
//        consumer.resume();

        //拉取消息
        while (true) {
            ConsumerRecords<String, String> records = consumer.poll(1000);
            for (ConsumerRecord<String, String> record : records) {
                System.out.println(record.key() + "------>" + record.value());
            }
        }
    }
}
