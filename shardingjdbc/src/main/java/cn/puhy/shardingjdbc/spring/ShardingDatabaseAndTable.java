package cn.puhy.shardingjdbc.spring;

import cn.puhy.shardingjdbc.spring.mapper.OrderMapper;
import cn.puhy.shardingjdbc.spring.model.Order;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * @author puhongyu
 * 2018/6/10 23:19
 */
public class ShardingDatabaseAndTable {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("mybatisShardingDatabaseAndTableContext.xml");
        OrderMapper orderMapper = applicationContext.getBean(OrderMapper.class);

        Order order = new Order();
        order.setUserId(32);
        order.setAddressId(21);
        order.setStatus("呵呵");
        orderMapper.insert(order);

        List<Order> list = orderMapper.queryById(9);
        for (Order order1 : list) {
            System.out.println(order1);
        }
    }
}
