package cn.puhy.shardingjdbc.spring.mapper;

import cn.puhy.shardingjdbc.spring.model.Order;

import java.util.List;

/**
 * @author puhongyu
 * 2018/6/10 14:58
 */
public interface OrderMapper {

    int insert(Order order);

    List<Order> queryById(int userId);
}
