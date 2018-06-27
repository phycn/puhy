package cn.puhy.eureka.consumer.controller;

import cn.puhy.springcloud.common.bean.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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

    /**
     * GET请求，使用getForEntity
     *
     * @return
     */
    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String hello() {
        //消费服务端的服务
        return restTemplate.getForEntity("http://hello-service/hello", String.class).getBody();
    }

    /**
     * GET请求，使用getForObject
     *
     * @return
     */
    @RequestMapping(value = "/object")
    public void object(@RequestParam("id") int id) {
        User user = restTemplate.getForObject("http://hello-service/object?id={1}", User.class, id);
        System.out.println(user);
    }

    /**
     * POST请求，有3种方法
     * postForEntity
     * postForObject
     * postForLocation
     */
    @RequestMapping(value = "/post")
    public void post() {
        User user = new User();
        user.setId(6677);
        user.setName("hehe");
        user.setAddress("yunyang");
        user = restTemplate.postForEntity("http://hello-service/post", user, User.class).getBody();
        System.out.println(user);
    }
}
