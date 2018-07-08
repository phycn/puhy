package cn.puhy.kafka;

import org.apache.kafka.common.serialization.Serializer;

import java.util.Map;

/**
 * @author PUHY
 * 2018-07-08 19:31
 */
public class MySerializer implements Serializer {
    @Override
    public void configure(Map configs, boolean isKey) {

    }

    @Override
    public byte[] serialize(String topic, Object data) {
        return new byte[0];
    }

    @Override
    public void close() {

    }
}
