package cn.puhy.eureka.consumer.controller;

import cn.puhy.eureka.consumer.hystrix.HystrixDemotionCommand;
import cn.puhy.springcloud.common.bean.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * 降级调用
 * @author PUHY
 * 2018-07-14 19:52
 */
@RestController
public class HystrixDemotionController {
    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/demotion/{id}")
    public User findById(@PathVariable Integer id) {
        HystrixDemotionCommand command = new HystrixDemotionCommand("orederGroup", restTemplate, id);
        //execute为同步方法，queue为异步方法
        User user = command.execute();
        return user;
    }
}
