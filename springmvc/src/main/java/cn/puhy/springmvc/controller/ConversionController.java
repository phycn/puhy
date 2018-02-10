package cn.puhy.springmvc.controller;

import cn.puhy.springmvc.domain.User;
import cn.puhy.springmvc.domain.UserEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author puhongyu
 * 2018/1/30 20:30
 */

@Controller
@RequestMapping("/conversion")
public class ConversionController {

    //@InitBinder在初始化时调用
    //添加自定义编辑器，这种方式只能在该控制器内使用
    @InitBinder
    public void initBinder(WebDataBinder binder) {
        System.out.println("@InitBinder标注的方法");
        binder.registerCustomEditor(User.class, new UserEditor());
    }

    //  http://localhost:8080/springmvc/conversion/handle1?user=phy:chengdu:123
    @RequestMapping("/handle1")
    public String handle1(@RequestParam(name = "user", required = false) User user) {

        System.out.println("转换后的：" + user);
        return "first/success";
    }
}
