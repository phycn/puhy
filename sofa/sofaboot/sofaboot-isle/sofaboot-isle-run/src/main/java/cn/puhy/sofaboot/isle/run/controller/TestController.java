package cn.puhy.sofaboot.isle.run.controller;

import cn.puhy.sofaboot.isle.api.MySofaService;
import com.alipay.sofa.runtime.api.annotation.SofaReference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author puhongyu
 * 2019/4/24 16:06
 */
@RestController
public class TestController {

    @SofaReference(uniqueId = "mySofaServiceImpl")
    private MySofaService mySofaService;

    @GetMapping("/hello")
    public void sayHello() {
        System.out.println(mySofaService.sayHello());
    }
}
