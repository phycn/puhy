package cn.puhy.feign;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author PUHY
 * 2018-07-01 13:55
 */
@RestController
public class FeignInheritController {

    @Autowired
    private FeignInheritService feignInheritService;

    @RequestMapping("/inherit")
    public String inherit(@RequestParam("name") String name) {
        return feignInheritService.inherit(name);
    }
}
