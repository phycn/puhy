package cn.puhy.study.rabbitmqspringboot.controller;

import cn.puhy.study.rabbitmqspringboot.producer.MQSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author PUHY
 * 2019-07-09 0:27
 */
@RestController
public class TestController {

    @Autowired
    private MQSender mqSender;

    @GetMapping("/send")
    public void send() {
        mqSender.send();
    }
}
