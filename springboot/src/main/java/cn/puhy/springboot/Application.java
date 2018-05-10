package cn.puhy.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author puhongyu
 * 2018/5/10 13:14
 */
@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        System.out.println("hello world");
        SpringApplication.run(Application.class);
    }
}
