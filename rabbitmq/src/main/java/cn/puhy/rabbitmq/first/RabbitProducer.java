package cn.puhy.rabbitmq.first;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.MessageProperties;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeoutException;

/**
 * 生产者
 *
 * @author PUHY
 * 2018-10-01 10:56
 */
public class RabbitProducer {
    
    private static final String EXCHANGE_NAME = "exchange_demo";
    //路由键
    private static final String ROUTING_KEY = "routingkey_demo";
    private static final String QUEUE_NAME = "queue_demo";
    private static final String IP = "192.168.47.136";
    //rabbitmq默认端口为5672
    private static final int PORT = 5672;
    
    public static void main(String[] args) throws IOException, TimeoutException {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost(IP);
        factory.setPort(PORT);
        factory.setUsername("root");
        factory.setPassword("root");

        //创建连接
        Connection connection = factory.newConnection();
        //创建信道
        Channel channel = connection.createChannel();
        //创建一个type=direct、持久化的、非自动删除的交换器
        // exchange 交换器的名称
        // type 交换器的类型
        // durable 是否持久化，持久化可以将交换器存盘
        // autoDelete 是否自动删除，这个交换器绑定的队列或者交换器都与此解绑
        // internal 是否是内置的，为true表示是，客户端程序无法直接发送消息到这个交换器，只能通过交换器路由到交换器这种方式
        // argument 一些结构化参数
        channel.exchangeDeclare(EXCHANGE_NAME, "direct", true, false, null);

        //创建一个持久化、非排他的、自动删除的队列
        // queue 队列名称
        // durable 是否持久化
        // exclusive 是否排他，为true表示排他，一个队列被声明为排他队列，该队列仅对首次声明它的连接可见，并在连接断开时自动删除。
        //   排他队列是基于连接(Connection)可见的，同一个连接不同信道是可以访问同一连接创建的排他队列，排他队列适用于一个客户端同时发送和读取消息的应用场景。
        // autoDelete 是否自动删除，至少有一个消费者连接到这个队列，之后所有与这个队列连接的消费者都断开时才会自动删除
        // arguments 参数
        Map<String, Object> arguments = new HashMap<>();
        //队列中所有消息的过期时间，单位为毫秒
        arguments.put("x-message-ttl", 6000);
        channel.queueDeclare(QUEUE_NAME, true, false, true, arguments);
        //将交换器与队列通过路由键绑定，第三个参数为绑定键，这里使用的是路由键
        channel.queueBind(QUEUE_NAME, EXCHANGE_NAME, ROUTING_KEY);
        //发送一条持久化消息
        String message = "hello puhy";
        // 参数mandatory为true时，交换器无法根据自身的类型和路由键找到一个符合条件的队列，rabbitmq会调用Basic.Return将消息返回生产者
        channel.basicPublish(EXCHANGE_NAME, ROUTING_KEY, MessageProperties.PERSISTENT_TEXT_PLAIN, message.getBytes());
        //添加监听
        channel.addReturnListener((replyCode, replyText, exchange, routingKey, properties, body) -> {
            String returnMsg = new String(body);
            System.out.println(returnMsg);
        });

        channel.close();
        connection.close();
    }
}
