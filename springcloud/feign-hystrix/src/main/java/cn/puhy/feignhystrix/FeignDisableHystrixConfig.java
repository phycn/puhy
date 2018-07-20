package cn.puhy.feignhystrix;

import feign.Feign;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

/**
 * @author PUHY
 * 2018-07-19 16:12
 */
@Configuration
public class FeignDisableHystrixConfig {

    @Bean
    @Scope("prototype")
    public Feign.Builder feignBuilder() {
        return Feign.builder();
    }
}
