package cn.puhy.eureka.registercenter;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author PUHY
 * 2018-06-24 20:13
 */
@EnableEurekaServer
@SpringBootApplication
public class RegisterCenterApplication {
    public static void main(String[] args) {
        new SpringApplicationBuilder(RegisterCenterApplication.class).web(true).run(args);
    }
}
