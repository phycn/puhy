package cn.puhy.rabbitmq.first;

import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * 消费者
 *
 * @author PUHY
 * 2018-10-01 14:13
 */
public class RabbitConsumer {

    private static final String QUEUE_NAME = "queue_demo";
    private static final String IP = "192.168.47.136";
    //rabbitmq默认端口为5672
    private static final int PORT = 5672;

    public static void main(String[] args) throws IOException, TimeoutException, InterruptedException {
        Address[] address = new Address[]{new Address(IP, PORT)};
        ConnectionFactory factory = new ConnectionFactory();
        factory.setUsername("root");
        factory.setPassword("root");

        //创建连接
        Connection connection = factory.newConnection(address);
        //创建信道
        final Channel channel = connection.createChannel();
        //设置客户端最多接收未被ack的消息的个数
        channel.basicQos(64);

        //回调函数
        Consumer consumer = new DefaultConsumer(channel) {

            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                System.out.println("收到的消息: " + new String(body));
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                //确认消息
                channel.basicAck(envelope.getDeliveryTag(), false);
            }
        };
        //推模式，由rabbitmq推送
        //queue 队列名称
        //autoAck 是否自动确认，一般设为false
        //consumerTag 消费者标签，用来区分多个消费者
        //noLocal 设置为true不能将同一个connection中生产者发送的消息传送给这个connection中的消费者
        //exclusive 是否排他
        //arguments 消费者其他参数
        //callback 回调函数
        channel.basicConsume(QUEUE_NAME, consumer);
        //拉模式
//        channel.basicGet(QUEUE_NAME, false);
        TimeUnit.SECONDS.sleep(5);
        channel.close();
        connection.close();
    }
}
