package cn.puhy.kafka.stream;

import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.KafkaStreams;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.StreamsConfig;
import org.apache.kafka.streams.kstream.KStream;
import org.apache.kafka.streams.kstream.KTable;
import org.apache.kafka.streams.kstream.Materialized;
import org.apache.kafka.streams.kstream.Produced;

import java.util.Arrays;
import java.util.Properties;

/**
 * 将一个主题的数据经过处理后放到另外一个主题里
 *
 * @author puhongyu
 * 2018/7/11 09:46
 */
public class FirstStream {
    public static void main(final String[] args) {
        Properties config = new Properties();
        //指定流处理应用的ID，必须配置
        config.put(StreamsConfig.APPLICATION_ID_CONFIG, "phy1");
        //kafka地址
        config.put(StreamsConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        //KEY的序列化和反序列化类
        config.put(StreamsConfig.DEFAULT_KEY_SERDE_CLASS_CONFIG, Serdes.String().getClass());
        //VALUE的序列化和反序列化类
        config.put(StreamsConfig.DEFAULT_VALUE_SERDE_CLASS_CONFIG, Serdes.String().getClass());

        StreamsBuilder builder = new StreamsBuilder();
        //从指定主题获取数据，流式计算
        KStream<String, String> textLines = builder.stream("phy");
        KTable<String, Long> wordCounts = textLines
                //通过空格将每一行文本分割成单词
                .flatMapValues(textLine -> Arrays.asList(textLine.toLowerCase().split("\\W+")))
                //将文本单词分组作为KEY
                .groupBy((key, word) -> word)
                .count(Materialized.as("counts-store"));
        //输出到的主题
        wordCounts.toStream().to("phy1", Produced.with(Serdes.String(), Serdes.Long()));

        KafkaStreams streams = new KafkaStreams(builder.build(), config);
        streams.start();
    }
}
