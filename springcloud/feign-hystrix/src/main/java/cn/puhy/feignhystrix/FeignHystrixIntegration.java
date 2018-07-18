package cn.puhy.feignhystrix;

import cn.puhy.springcloud.common.service.FeignHystrixService;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author PUHY
 * 2018-07-18 22:29
 */
//fallback指定降级逻辑实现
@FeignClient(name = "hello-service", fallback = FeignHystrixFallback.class)
public interface FeignHystrixIntegration extends FeignHystrixService {

    @RequestMapping("/feignHystrix")
    String feignHystrix(@RequestParam("name") String name);
}
