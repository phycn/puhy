package cn.puhy.springmvc.controller;

import cn.puhy.springmvc.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author puhongyu
 * 2018/1/31 22:19
 */

@Controller
@RequestMapping("/format")
public class FormatController {

    //测试URL http://localhost:8080/springmvc/format/handle1
    //测试JSON    {"age":66, "name":"haha", "password":"12", "birthday":"1989-12-31", "salary":"2500.18"}
    @RequestMapping("/handle1")
    public String handle1(@RequestBody User user) {
        System.out.println("收到的：" + user);
        return "/first/success";
    }
}
