package cn.puhy.withouteureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * @author PUHY
 * 2018-06-30 17:08
 */
@SpringBootApplication
public class WithoutEurekaApplication {
    @Bean
    @LoadBalanced
        //ribbon负载均衡
    RestTemplate restTemplate() {
        return new RestTemplate();
    }

    public static void main(String[] args) {
        SpringApplication.run(WithoutEurekaApplication.class);
    }
}
