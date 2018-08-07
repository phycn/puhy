package cn.puhy.stream;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

/**
 * @author PUHY
 * 2018-08-07 21:19
 */
public interface StreamClient {

    //订阅的队列
    @Input("stream1")
    SubscribableChannel input();

    //发送消息的队列
    @Output("stream2")
    MessageChannel output();
}
