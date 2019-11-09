package cn.puhy.study.shardingjdbc.springboot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("cn.puhy.study.shardingjdbc.springboot.dao")
public class ShardingjdbcSpringbootApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShardingjdbcSpringbootApplication.class, args);
    }

}
