package cn.puhy.configserver.rabbitmq;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * 生产者
 * @author puhongyu
 * 2018/7/30 22:44
 */
@Component
public class Producer {

    @Autowired
    private AmqpTemplate amqpTemplate;

    public String send(String mess) {
        String message = "hello " + mess + " " + new Date();
        System.out.println("send: " + message);
        //发送字符串到hello队列
        amqpTemplate.convertAndSend("hello", message);
        return message;
    }
}
