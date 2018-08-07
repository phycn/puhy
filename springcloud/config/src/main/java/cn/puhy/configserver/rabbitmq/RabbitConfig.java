package cn.puhy.configserver.rabbitmq;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * @author puhongyu
 * 2018/7/30 22:51
 */
@Configuration
public class RabbitConfig {

    //创建队列
    @Bean
    public Queue helloQueue() {
        return new Queue("hello");
    }
}
