package cn.puhy.eureka.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;

/**
 * 该类为Ribbon的配置类
 * 注意：这个类要放在@SpringBootApplication注解能扫描到的包内，也就是ConsumerApplication类
 */
@Configuration
public class RibbonConfiguration {
    @Bean
    public IRule ribbonRule() {
        System.out.println("加载到了呢");
        // 负载均衡规则，改为随机
        return new RandomRule();
    }
}