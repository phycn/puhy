package cn.puhy.springmvc.controller;

import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.WebUtils;

import javax.servlet.http.HttpServletRequest;

//标注为处理请求的控制器
@Controller
//  /first/*/login  匹配/first/aaa/login，/first/bbb/login
//  /first/**/login  匹配/first/aaa/login，/first/aaa/bbb/login
//  /first/login??  匹配/first/loginaa，first/loginbb
//  /first/{id}     匹配/first/123，/first/987
//  /first/**/{id}  匹配/first/aaa/bbb/123，/first/aaa/456

//处理来自/first的URL请求
@RequestMapping("/first")
public class FirstController {

    @RequestMapping("/first/{id}")
    //@PathVariable从URL中获取
    public ModelAndView first(@PathVariable("id") String id) {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("first/register");
        mav.addObject("id", id);
        return mav;
    }

    @RequestMapping("/login")
    public ModelAndView login() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("first/success");
        mav.addObject("phy", "蒲红宇");
        return mav;
    }

    @RequestMapping("/handle1")
    //@RequestParam绑定请求参数
    public String handle1(@RequestParam("name") String name, @RequestParam("age") String age) {
        System.out.println(name + " " + age);
        return "first/success";
    }

    //使用POST传输
    @RequestMapping(value = "/postMethod", method = RequestMethod.POST)
    public String postMethod(HttpServletRequest request) {
        System.out.println(request.getParameter("name"));
        System.out.println(request.getParameter("age"));
        return "first/success";
    }

    @RequestMapping("/handle2")
    //@CookieValue绑定cookie值，@RequestHeader绑定HTTP报文头信息
    public String handle2(@CookieValue("JSESSIONID") String sessionId, @RequestHeader("Accept-Language") String acceptLanguage) {
        System.out.println("JSESSIONID:" + sessionId);
        System.out.println("Accept-Lanuage:" + acceptLanguage);
        return "first/success";
    }

    @RequestMapping(value = "/handle3")
    public String handle3(@MatrixVariable String a) {
        System.out.println(a);
        return "first/success";
    }

    //使用Servlet API对象作为入参
    @RequestMapping(value = "/handle4")
    public String handle4(HttpServletRequest request) {
        String name = WebUtils.findParameterValue(request, "name");
        System.out.println(name);
        return "first/success";
    }
}
