package cn.puhy.springmvc.controller;

import cn.puhy.springmvc.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author puhongyu
 * 2018/2/3 19:51
 */
@Controller
@RequestMapping("/tag")
public class TagController {

    @RequestMapping("/taglogin")
    public String tagLogin() {

        return "tag";
    }

    @RequestMapping("/testSubmit")
    public void submit(@RequestBody User user) {
        System.out.println(user);
    }
}
