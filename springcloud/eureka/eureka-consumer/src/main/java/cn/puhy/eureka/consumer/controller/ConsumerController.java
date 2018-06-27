package cn.puhy.eureka.consumer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * 服务消费
 *
 * @author puhongyu
 * 2018/6/27 10:39
 */
@RestController
public class ConsumerController {

    @Autowired
    RestTemplate restTemplate;

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String hello() {
        //消费服务端的服务
        return restTemplate.getForEntity("http://hello-service/hello", String.class).getBody();
    }
}
