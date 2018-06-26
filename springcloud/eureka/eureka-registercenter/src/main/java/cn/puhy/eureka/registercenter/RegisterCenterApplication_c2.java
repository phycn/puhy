package cn.puhy.eureka.registercenter;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * 注册中心集群2
 * JVM参数：-Dspring.profiles.active=c2
 *
 * @author PUHY
 * 2018-06-24 20:13
 */
@EnableEurekaServer
@SpringBootApplication
public class RegisterCenterApplication_c2 {
    public static void main(String[] args) {
        new SpringApplicationBuilder(RegisterCenterApplication_c2.class).web(true).run(args);
    }
}
