package cn.puhy.study.rabbitmqspringboot.consumer;

import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * @author PUHY
 * 2019-07-09 0:30
 */
@Component
public class Receiver {

    @RabbitListener(queues = "queue_demo")
    public void receive(Message msg, Channel channel) throws IOException {
        System.out.println("收到的消息：" + new String(msg.getBody()));
        channel.basicAck(msg.getMessageProperties().getDeliveryTag(), true);
    }
}
