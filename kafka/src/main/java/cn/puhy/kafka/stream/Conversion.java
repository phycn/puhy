package cn.puhy.kafka.stream;

import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.common.utils.Bytes;
import org.apache.kafka.streams.KafkaStreams;
import org.apache.kafka.streams.KeyValue;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.StreamsConfig;
import org.apache.kafka.streams.kstream.*;
import org.apache.kafka.streams.state.KeyValueStore;

import java.util.Arrays;
import java.util.Properties;

/**
 * 变换操作
 *
 * @author puhongyu
 * 2018/7/12 11:24
 */
public class Conversion {
    public static void main(String[] args) {
        Properties config = new Properties();
        //指定流处理应用的ID，必须配置
        config.put(StreamsConfig.APPLICATION_ID_CONFIG, "stream1");
        //kafka地址
        config.put(StreamsConfig.BOOTSTRAP_SERVERS_CONFIG, "192.168.47.129:9092,192.168.47.130:9092,192.168.47.131:9092");
        //KEY的序列化和反序列化类
        config.put(StreamsConfig.DEFAULT_KEY_SERDE_CLASS_CONFIG, Serdes.String().getClass());
        //VALUE的序列化和反序列化类
        config.put(StreamsConfig.DEFAULT_VALUE_SERDE_CLASS_CONFIG, Serdes.String().getClass());

        StreamsBuilder builder = new StreamsBuilder();
        KStream<String, String> stream1 = builder.stream("stream1");

        //过滤流
        KStream<String, String> filterStream1 = stream1.filter(new Predicate<String, String>() {
            @Override
            //过滤操作，将不满足条件的数据去掉
            public boolean test(String key, String value) {
                if (value == null || value.equals("")) {
                    return false;
                }
                return true;
            }
        });

        //将value解析，并放入Iterable中
        KStream<String, String> wordStream1 = filterStream1.flatMapValues(new ValueMapper<String, Iterable<? extends String>>() {
            @Override
            public Iterable<? extends String> apply(String value) {
                //将value以"，"分隔，放入Iterable
                return Arrays.asList(value.split(","));
            }
        });
        //将Iterable的东西转换为KeyValue，也就是数据
        wordStream1 = wordStream1.map(new KeyValueMapper<String, String, KeyValue<? extends String, ? extends String>>() {
            @Override
            public KeyValue<? extends String, ? extends String> apply(String key, String value) {
                //将上一步分解的每个单词构造成KeyValue，键与值相同
                return new KeyValue<>(value, value);
            }
        });
        //将单词按键分组
        KGroupedStream<String, String> wordGroup = wordStream1.groupBy(new KeyValueMapper<String, String, String>() {
            @Override
            public String apply(String key, String value) {
                return value;
            }
        });
        //统计单词数
        //这里有个坑，从主题phy1拉取数据时value的反序列化要用LongDeserializer
        KTable<String, Long> words = wordGroup.count(Materialized.<String, Long, KeyValueStore<Bytes, byte[]>>as("counts-store"));
        words.toStream().to("phy1", Produced.with(Serdes.String(), Serdes.Long()));

        KafkaStreams streams = new KafkaStreams(builder.build(), config);
        streams.start();
    }
}
