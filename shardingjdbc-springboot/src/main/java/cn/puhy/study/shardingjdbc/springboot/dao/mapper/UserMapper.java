package cn.puhy.study.shardingjdbc.springboot.dao.mapper;

import cn.puhy.study.shardingjdbc.springboot.dao.model.User;

/**
 * @author puhongyu
 * 2018/6/10 14:58
 */
public interface UserMapper {

    int insert(User user);

    User queryById(int id);

    User queryByMobile(String mobile);
}
