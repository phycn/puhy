package cn.puhy.stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author PUHY
 * 2018-08-07 21:46
 */
@Component
public class StreamProducer {

    @Autowired
    StreamClient streamClient;

    public void process() {
        String message = "now time: " + new Date();
        streamClient.output().send(MessageBuilder.withPayload(message).build());
    }

    //发送对象
    public void processObj() {
        Bean bean = new Bean();
        bean.setField1("hehe");
        bean.setField2("haha");
        streamClient.output().send(MessageBuilder.withPayload(bean).build());
    }
}
