package cn.puhy.kafka.spring;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.kafka.core.KafkaTemplate;

/**
 * @author PUHY
 * 2018-07-09 20:59
 */
public class SpringConsumer {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("spring/consumer.xml");
    }
}
