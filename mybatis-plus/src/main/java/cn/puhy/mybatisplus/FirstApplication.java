package cn.puhy.mybatisplus;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author PUHY
 * 2018-11-20 22:50
 */
@SpringBootApplication
@MapperScan("cn.puhy.mybatisplus")
public class FirstApplication {
    public static void main(String[] args) {
        SpringApplication.run(FirstApplication.class);
    }
}
