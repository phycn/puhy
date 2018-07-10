package cn.puhy.kafka.spring;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.kafka.core.KafkaTemplate;

/**
 * @author PUHY
 * 2018-07-09 20:59
 */
public class SpringProducer {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("spring/producer.xml");

        KafkaTemplate<String, String> template = ctx.getBean(KafkaTemplate.class);
        template.send("phy2", 0, "spring", "整合的spring22");
//        ctx.close();
    }
}
