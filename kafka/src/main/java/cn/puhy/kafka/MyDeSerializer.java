package cn.puhy.kafka;

import org.apache.kafka.common.serialization.Deserializer;

import java.util.Map;

/**
 * @author PUHY
 * 2018-07-08 19:38
 */
public class MyDeSerializer implements Deserializer {
    @Override
    public void configure(Map configs, boolean isKey) {

    }

    @Override
    public Object deserialize(String topic, byte[] data) {
        return null;
    }

    @Override
    public void close() {

    }
}
