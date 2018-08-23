package cn.puhy.springbootstartertest;

import cn.puhy.springbootstarter.PhyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author puhongyu
 * 2018/8/23 00:13
 */
@RestController
public class StarterTestController {

    @Autowired
    PhyService phyService;

    @GetMapping("/phy")
    public String sayHello() {
        return phyService.getInfo();
    }
}
