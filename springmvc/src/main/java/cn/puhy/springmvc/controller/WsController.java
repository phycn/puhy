package cn.puhy.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author puhongyu
 * 2018/2/6 20:21
 */
@Controller
@RequestMapping("/ws")
public class WsController {

    @RequestMapping("/ws")
    public String ws() {
        return "ws";
    }
}
