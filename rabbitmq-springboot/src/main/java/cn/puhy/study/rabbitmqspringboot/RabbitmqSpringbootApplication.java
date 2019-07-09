package cn.puhy.study.rabbitmqspringboot;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableRabbit
public class RabbitmqSpringbootApplication {

    public static void main(String[] args) {
        SpringApplication.run(RabbitmqSpringbootApplication.class, args);
    }
}
