package cn.puhy.zuul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

/**
 * @author PUHY
 * 2018-07-21 22:30
 */
@SpringBootApplication
@EnableZuulProxy            //开启Zuul
public class ZuulApplication {
    public static void main(String[] args) {
        SpringApplication.run(ZuulApplication.class, args);
    }

    //启动过滤器
    @Bean
    public MyFilter setMyFilter() {
        return new MyFilter();
    }

//    @Bean
//    public ErrorFilter setErrorFilter() {
//        return new ErrorFilter();
//    }
}
