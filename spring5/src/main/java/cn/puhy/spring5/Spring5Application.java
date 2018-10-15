package cn.puhy.spring5;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.reactive.config.EnableWebFlux;

@SpringBootApplication
@EnableWebFlux
public class Spring5Application {

    public static void main(String[] args) {
        SpringApplication.run(Spring5Application.class, args);
    }
}
