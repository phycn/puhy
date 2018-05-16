package cn.puhy.springbootfirst.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author puhongyu
 * 2018/5/11 08:48
 */
@Controller
public class ThymeleafController {
    @RequestMapping("/thymeleaf")
    public String thymeleaf(ModelMap modelMap) {
        modelMap.put("name", "蒲红宇");
        //对应templates目录下的thymeleaf.html
        return "thymeleaf";
    }
}
