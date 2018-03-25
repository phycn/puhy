package cn.puhy.mymvc.controller;

import cn.puhy.mymvc.annotiion.Controller;
import cn.puhy.mymvc.annotiion.Qualifier;
import cn.puhy.mymvc.service.MyService;
import cn.puhy.mymvc.annotiion.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller("/my")
public class MyController {

    @Qualifier("myService")
    MyService myService;

    @RequestMapping("/insert")
    public String insert(HttpServletRequest request, HttpServletResponse response) {

        myService.insert();
        return "ok";
    }
}
