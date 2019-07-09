package cn.puhy.study.rabbitmqspringboot;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;

/**
 * @author PUHY
 * 2019-07-09 0:38
 */
//@Configuration
public class MqConfig {
    @Bean
    Queue queue() {
        return new Queue("queue_demo", true);
    }

    @Bean
    TopicExchange exchange() {
        return new TopicExchange("exchange_demo");
    }

    @Bean
    Binding binding(Queue queue, TopicExchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with("routingkey_demo" );
    }
}
