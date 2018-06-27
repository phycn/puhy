package cn.puhy.eureka.server.controller;

import cn.puhy.springcloud.common.bean.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

/**
 * @author PUHY
 * 2018-06-24 21:00
 */
@RestController
public class HelloController {

    @Autowired
    private DiscoveryClient client;

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String index() {
        System.out.println("hehe phy");
        return "Hello phy";
    }

    @RequestMapping(value = "/object", method = RequestMethod.GET)
    public User object(@RequestParam("id") int id) {
        User user = new User();
        user.setId(id);
        user.setName("puhongyu");
        user.setAddress("chengdu");
        return user;
    }

    @RequestMapping(value = "/post", method = RequestMethod.POST)
    public User post(@RequestBody User user) {
        System.out.println("收到的：" + user);
        user.setId(1122);
        user.setName("puhy");
        user.setAddress("chongqing");
        return user;
    }
}
