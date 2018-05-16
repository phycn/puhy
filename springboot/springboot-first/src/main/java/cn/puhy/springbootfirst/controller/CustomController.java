package cn.puhy.springbootfirst.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author puhongyu
 * 2018/5/11 08:48
 */
@RestController
public class CustomController {

    //@Value获取application.properties中的属性
    @Value("${myName}")
    private String name;

    @Value("${myAge}")
    private int age;

    @Value("${myInfo}")
    private String myInfo;

    @GetMapping("/custom")
    public String custom() {
        return "hello " + name + " " + myInfo;
    }
}
