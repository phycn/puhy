package cn.puhy.stream;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;

/**
 * 接收MQ消息
 *
 * @author PUHY
 * 2018-08-07 21:20
 */
@Component
@EnableBinding(StreamClient.class)
public class StreamConsumer {

    //监听stream2队列
    @StreamListener("stream2")
    //将返回发送给stream1队列
    @SendTo("stream1")
    public String process(Bean message) {
        System.out.println(message.getClass().getName());
        System.out.println("stream2收到的消息：" + message);
        return "stream2的回馈";
    }

    @StreamListener("stream1")
    public void process1(String message) {
        System.out.println("stream1收到的消息：" + message);
    }
}
