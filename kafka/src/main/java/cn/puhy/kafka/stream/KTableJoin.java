package cn.puhy.kafka.stream;

import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.KafkaStreams;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.StreamsConfig;
import org.apache.kafka.streams.kstream.*;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

/**
 * @author PUHY
 * 2018-07-11 22:39
 */
public class KTableJoin {
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
        //从两个主题获取数据
        KTable<String, String> leftTable = builder.table("stream1");
        KTable<String, String> rightTable = builder.table("stream2");

        //ValueJoiner的三个泛型分别为第一个值，第二个值，JOIN后的值
        //join相当于SQL的inner join
        //leftJoin相当于SQL的left join
        //rightJoin相当于SQL的right join
        KTable<String, String> joinTable = leftTable.join(rightTable, new ValueJoiner<String, String, String>() {
            //方法为join，需要两个键相同才能触发
            //方法为leftJoin，左流有数据就会触发
            //方法为rightJoin，右流有数据就会触发
            @Override
            public String apply(String leftValue, String rightValue) {
                System.out.println("left: " + leftValue + ", right: " + rightValue);
                return leftValue + rightValue;
            }
            //JoinWindows.of 取之前最大时间及之后最大时间跨度的集合，比如
        });

        //将JOIN后的流输出到指定主题
        joinTable.toStream().to("phy1", Produced.with(Serdes.String(), Serdes.String()));

        KafkaStreams streams = new KafkaStreams(builder.build(), config);
        streams.start();
    }
}
