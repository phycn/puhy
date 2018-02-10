package cn.puhy.springmvc.controller;

import cn.puhy.springmvc.domain.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.Callable;

@RestController
@RequestMapping("/async")
public class AsyncController {

    @RequestMapping("/handle1")
    public Callable<User> handle1() {

        return () -> {
            //暂停5秒
            Thread.sleep(5000);
            User user = new User();
            user.setName("王五");
            user.setAge(33);
            return user;
        };
    }
}
