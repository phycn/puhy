package cn.puhy.kafka.stream;

import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.KafkaStreams;
import org.apache.kafka.streams.KeyValue;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.StreamsConfig;
import org.apache.kafka.streams.kstream.*;

import java.util.Properties;

/**
 * 聚合操作
 *
 * @author PUHY
 * 2018-07-12 22:36
 */
public class Aggregate {
    public static void main(String[] args) {

        StreamsBuilder builder = new StreamsBuilder();
        KStream<String, String> stream1 = builder.stream("stream1");

        //将VALUE转换为Integer型
        KStream<String, Integer> stream2 = stream1.map(new KeyValueMapper<String, String, KeyValue<String, Integer>>() {
            @Override
            public KeyValue<String, Integer> apply(String key, String value) {
                return new KeyValue<>(key, Integer.parseInt(value));
            }
        });
        KGroupedStream<String, Integer> groupedStream = stream2.groupByKey(Serialized.with(Serdes.String(), Serdes.Integer()));
        groupedStream.windowedBy(TimeWindows.of(1000).advanceBy(1000));
        KTable<String, Integer> maxStream = groupedStream.aggregate(new Initializer<Integer>() {
            //初始值
            @Override
            public Integer apply() {
                return Integer.MIN_VALUE;
            }
        }, new Aggregator<String, Integer, Integer>() {
            @Override
            public Integer apply(String key, Integer value, Integer aggregate) {
                return value > aggregate ? value : aggregate;
            }
        });

        Properties config = new Properties();
        //指定流处理应用的ID，必须配置
        config.put(StreamsConfig.APPLICATION_ID_CONFIG, "stream1");
        //kafka地址
        config.put(StreamsConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        //KEY的序列化和反序列化类
        config.put(StreamsConfig.DEFAULT_KEY_SERDE_CLASS_CONFIG, Serdes.String().getClass());
        //VALUE的序列化和反序列化类
        config.put(StreamsConfig.DEFAULT_VALUE_SERDE_CLASS_CONFIG, Serdes.String().getClass());

        KafkaStreams streams = new KafkaStreams(builder.build(), config);
        streams.start();
    }
}
