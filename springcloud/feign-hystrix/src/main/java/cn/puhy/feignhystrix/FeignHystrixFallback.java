package cn.puhy.feignhystrix;

import org.springframework.stereotype.Component;

/**
 * @author PUHY
 * 2018-07-18 22:34
 */
@Component
public class FeignHystrixFallback implements FeignHystrixIntegration {
    @Override
    public String feignHystrix(String name) {
        return "降级方法！！！";
    }
}
