package cn.puhy.eureka.server;

import cn.puhy.springcloud.common.service.FeignHystrixService;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author PUHY
 * 2018-07-18 22:21
 */
@RestController
public class FeignHystrixServiceController implements FeignHystrixService {
    @Override
    public String feignHystrix(@RequestParam("name") String name) {
        return "这是feign和hystrix的整合，你知道吗？" + name;
    }
}
