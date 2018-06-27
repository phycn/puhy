package cn.puhy.eureka.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * 服务提供者
 * JVM参数：-Dspring.profiles.active=c1
 * @author PUHY
 * 2018-06-24 20:59
 */
@EnableDiscoveryClient
@SpringBootApplication
public class Server1Application {
    public static void main(String[] args) {
        SpringApplication.run(Server1Application.class);
    }
}
