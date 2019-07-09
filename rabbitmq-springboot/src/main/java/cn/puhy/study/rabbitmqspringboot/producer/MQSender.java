package cn.puhy.study.rabbitmqspringboot.producer;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author PUHY
 * 2019-07-09 0:14
 */
@Component
public class MQSender {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void send() {
        rabbitTemplate.convertAndSend("exchange_demo", "routingkey_demo", "1212");
    }
}
