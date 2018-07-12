package cn.puhy.kafka.stream;

import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.KeyValue;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.kstream.KStream;
import org.apache.kafka.streams.kstream.KeyValueMapper;
import org.apache.kafka.streams.kstream.Produced;
import org.apache.kafka.streams.kstream.Serialized;

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
        stream2.groupByKey(Serialized.with(Serdes.String(), Serdes.Integer()));
    }
}
