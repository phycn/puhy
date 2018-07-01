package cn.puhy.eureka.consumer.controller;

import cn.puhy.eureka.consumer.hystrix.HystrixFirstService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author PUHY
 * 2018-07-01 22:52
 */
@RestController
public class HystrixFirstController {

    @Autowired
    private HystrixFirstService service;

    @RequestMapping("/hystrix-first")
    public String hystrixFirst() {
        return service.hystrixFirst();
    }
}
