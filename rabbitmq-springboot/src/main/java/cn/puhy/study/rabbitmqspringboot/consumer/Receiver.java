package cn.puhy.study.rabbitmqspringboot.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author PUHY
 * 2019-07-09 0:30
 */
@Component
public class Receiver {

    @RabbitListener(queues = "queue_demo")
    public void receive(String msg) {
        System.out.println("收到的消息：" + msg);
    }
}
