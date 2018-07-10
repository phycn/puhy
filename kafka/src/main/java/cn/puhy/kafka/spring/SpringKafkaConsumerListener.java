package cn.puhy.kafka.spring;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.listener.MessageListener;

/**
 * 监听器
 *
 * @author PUHY
 * 2018-07-09 21:43
 */
public class SpringKafkaConsumerListener implements MessageListener<String, String> {
    @Override
    public void onMessage(ConsumerRecord<String, String> data) {
        if (data != null) {
            System.out.println("收到的消息：" + data.value());
        }
    }
}
