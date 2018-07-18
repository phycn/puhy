package cn.puhy.feignhystrix;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author PUHY
 * 2018-07-18 22:45
 */
@RestController
public class FeignHystrixController {

    @Autowired
    private FeignHystrixIntegration feignHystrixIntegration;

    @RequestMapping("/feignHystrix")
    public String feignHystrix(@RequestParam("name") String name) {
        return feignHystrixIntegration.feignHystrix(name);
    }
}
