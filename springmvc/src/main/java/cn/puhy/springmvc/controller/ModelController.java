package cn.puhy.springmvc.controller;

import cn.puhy.springmvc.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

//@SessionAttributes会将模型暂存到HttpSession中，多个请求可以共用该模型
@Controller
@RequestMapping("/model")
@SessionAttributes("user")
public class ModelController {

    //http://localhost:8080//springmvc/model/handle1?age=28&name=puhy&password=123908
    //@ModelAttribute会添加到模型中，视图对象可以获取到
    //如果直接返回模型字符串不能用@RestController
    //这里的User对象会先获得address属性，再根据HTTP请求进行填充
    @RequestMapping("/handle1")
    public String handle1(@ModelAttribute("user") User user) {

        System.out.println("收到的：" + user);
        user.setName("填充的值");
        return "model";
    }

    //在调用目标方法前(比如前面的handle1)，会先执行标注了@ModelAttribute的方法，并将返回值添加到模型中,会先赋值给其他同样命名的入参
    @ModelAttribute("user")
    public User getUser() {
        User user = new User();
        user.setAddress("@ModelAttribute方法填充的值");
        return user;
    }

    //ModelMap里有隐含的模型数据
    @RequestMapping("/handle2")
    public String handle2(ModelMap modelMap) {

        User user = (User) modelMap.get("user");
        user.setName("ModelMap");
        return "model";
    }

    @RequestMapping("/handle3")
    public String handle3(@ModelAttribute("user") User user) {

        //会将user保存到HttpSession中，与handle4虽然不是同一个请求，但handle4仍然能获取设置的name
        user.setName("handle3填充的值");
        //redirect会重新发起一个请求，forward与当前请求同属一个请求
        return "redirect:/model/handle4";
    }

    @RequestMapping("/handle4")
    public String handle4(ModelMap modelMap, SessionStatus sessionStatus) {

        User user = (User) modelMap.get("user");
        System.out.println("handle4:" + user);
        //让springmvc清除对应的会话属性
        sessionStatus.setComplete();
        return "model";
    }
}
