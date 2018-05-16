package cn.puhy.springbootfirst.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author puhongyu
 * 2018/5/11 08:48
 */
@RestController
public class FirstController {
    @GetMapping("/hello")
    public String sayHello() {
        return "hello phy";
    }
}
