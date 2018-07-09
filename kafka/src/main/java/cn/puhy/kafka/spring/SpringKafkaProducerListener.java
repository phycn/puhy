package cn.puhy.kafka.spring;

import org.apache.kafka.clients.producer.RecordMetadata;
import org.springframework.kafka.support.ProducerListener;

/**
 * 监听器
 *
 * @author PUHY
 * 2018-07-09 20:35
 */
public class SpringKafkaProducerListener implements ProducerListener<String, String> {

    //消息发送成功的处理
    @Override
    public void onSuccess(String topic, Integer partition, String key, String value, RecordMetadata recordMetadata) {
        System.out.println("主题名：" + topic);
        System.out.println("分区号：" + partition);
        System.out.println(key + "=" + value);
    }

    //消息发送失败的处理
    @Override
    public void onError(String topic, Integer partition, String key, String value, Exception exception) {
        exception.printStackTrace();
    }
}
