package cn.puhy.configserver.rabbitmq;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author puhongyu
 * 2018/7/30 22:48
 */
@Component
@RabbitListener(queues = "hello")   //监听hello队列
public class Consumer {

    //对消息的处理方法
    @RabbitHandler
    public void process(String hello) {
        System.out.println("receiver: " + hello);
    }
}
