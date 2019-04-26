package cn.puhy.sofarpc.consumer.controller;

import cn.puhy.sofarpc.consumer.MySofaRpcConsumer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author puhongyu
 * 2019/4/26 09:50
 */
@RestController
public class TestController {

    @Autowired
    private MySofaRpcConsumer mySofaRpcConsumer;

    @GetMapping("/hello")
    public String sayHello() {
        return mySofaRpcConsumer.consumer();
    }
}
