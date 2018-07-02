package cn.puhy.eureka.consumer;

import cn.puhy.eureka.config.RibbonConfiguration;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Configuration;

/**
 * 使用RibbonClient，为特定name的Ribbon Client自定义配置.
 * 使用@RibbonClient的configuration属性，指定Ribbon的配置类.
 * 这个类要放在@SpringBootApplication注解能扫描到的包内
 */
@Configuration
//指定的服务使用配置的负载均衡策略
@RibbonClient(name = "hello-service", configuration = RibbonConfiguration.class)
public class ConsumerConfiguration {
}