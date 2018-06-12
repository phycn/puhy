package cn.puhy.shardingjdbc.spring.mapper;

import cn.puhy.shardingjdbc.spring.model.User;

/**
 * @author puhongyu
 * 2018/6/10 14:58
 */
public interface UserMapper {

    int insert(User user);

    User queryById(int id);
}
