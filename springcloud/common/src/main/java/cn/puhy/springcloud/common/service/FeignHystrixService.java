package cn.puhy.springcloud.common.service;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author PUHY
 * 2018-07-18 22:13
 */
public interface FeignHystrixService {

    @RequestMapping("/feignHystrix")
    String feignHystrix(@RequestParam("name") String name);
}
