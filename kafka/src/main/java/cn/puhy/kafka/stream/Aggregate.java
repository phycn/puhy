package cn.puhy.kafka.stream;

import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.common.utils.Bytes;
import org.apache.kafka.streams.KafkaStreams;
import org.apache.kafka.streams.KeyValue;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.StreamsConfig;
import org.apache.kafka.streams.kstream.*;
import org.apache.kafka.streams.state.WindowStore;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.regex.Pattern;

/**
 * 聚合操作
 *
 * @author PUHY
 * 2018-07-12 22:36
 */
public class Aggregate {
    public static void main(String[] args) {

        Pattern pattern = Pattern.compile("^[0-9]*$");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        StreamsBuilder builder = new StreamsBuilder();
        KStream<String, String> stream1 = builder.stream("stream1");
        //过滤掉非数字数据
        stream1 = stream1.filter(new Predicate<String, String>() {
            @Override
            public boolean test(String key, String value) {
                if (value == null || value.equals("") || !pattern.matcher(value).matches()) {
                    return false;
                }
                return true;
            }
        });
        //将VALUE转换为Integer型
        KStream<String, Integer> stream2 = stream1.map(new KeyValueMapper<String, String, KeyValue<String, Integer>>() {
            @Override
            public KeyValue<String, Integer> apply(String key, String value) {
                return new KeyValue<>(key, Integer.parseInt(value));
            }
        });
        KGroupedStream<String, Integer> groupedStream = stream2.groupByKey(Serialized.with(Serdes.String(), Serdes.Integer()));
        //时间窗口，of里的参数为窗口时间，advanceBy里的参数为跳跃时间，两个相等为翻转窗口，of里的大于advanceBy里的为跳跃窗口
        TimeWindowedKStream<String, Integer> windowedKStream = groupedStream.windowedBy(TimeWindows.of(30000).advanceBy(30000));
        KTable<Windowed<String>, Integer> max = windowedKStream.aggregate(new Initializer<Integer>() {
            @Override
            public Integer apply() {
                return 0;
            }
        }, new Aggregator<String, Integer, Integer>() {
            @Override
            //聚合
            public Integer apply(String key, Integer value, Integer aggregate) {
                System.out.println("value: " + value + ", aggregate: " + aggregate);
                return value + aggregate;
            }
        });

        max.toStream().map(new KeyValueMapper<Windowed<String>, Integer, KeyValue<String, Integer>>() {
            @Override
            public KeyValue<String, Integer> apply(Windowed<String> key, Integer value) {
                System.out.println("start: " + sdf.format(new Date(key.window().start())) + ",end: " + sdf.format(new Date(key.window().end())));
                return new KeyValue<String, Integer>(key.key(), value);
            }
        }).to("phy1", Produced.with(Serdes.String(), Serdes.Integer()));

        Properties config = new Properties();
        //指定流处理应用的ID，必须配置
        config.put(StreamsConfig.APPLICATION_ID_CONFIG, "stream1");
        //kafka地址
        config.put(StreamsConfig.BOOTSTRAP_SERVERS_CONFIG, "192.168.47.129:9092,192.168.47.130:9092,192.168.47.131:9092");
        //KEY的序列化和反序列化类
        config.put(StreamsConfig.DEFAULT_KEY_SERDE_CLASS_CONFIG, Serdes.String().getClass());
        //VALUE的序列化和反序列化类
        config.put(StreamsConfig.DEFAULT_VALUE_SERDE_CLASS_CONFIG, Serdes.String().getClass());

        KafkaStreams streams = new KafkaStreams(builder.build(), config);
        streams.start();
    }
}
