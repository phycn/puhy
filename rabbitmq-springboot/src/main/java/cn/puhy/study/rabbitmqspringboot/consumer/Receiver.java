package cn.puhy.study.rabbitmqspringboot.consumer;

import com.rabbitmq.client.Channel;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * @author PUHY
 * 2019-07-09 0:30
 */
@Component
public class Receiver {

    @RabbitListener(queues = "queue_demo")  // 组合注解，可以配置@QueueBinding @Queue @Exchange
    public void receive(Message msg, Channel channel) throws IOException {
        System.out.println("收到的消息：" + msg.getPayload());
        long delieryTag = (long) msg.getHeaders().get(AmqpHeaders.DELIVERY_TAG);
//        channel.basicAck(delieryTag, false);
    }
}
