package cn.puhy.btrace;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author puhongyu
 * 2018/8/16 23:04
 */
@RestController
public class BtraceController {

    @GetMapping("/hello/{name}")
    public String hello(@PathVariable("name") String name) {
        return "hello " + name;
    }

    @GetMapping("/returnArg")
    public String returnArg() {
        return "拦截返回参数";
    }

    @GetMapping("/exception")
    public String exception() {
        try {
            System.out.println("1/0");
        } catch(Exception e) {
            
        }
        return "拦截获取异常";
    }

    @GetMapping("/object")
    public User object(User user) {
        return user;
    }
}
