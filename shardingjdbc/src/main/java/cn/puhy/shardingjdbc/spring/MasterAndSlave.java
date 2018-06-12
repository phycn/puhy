package cn.puhy.shardingjdbc.spring;

import cn.puhy.shardingjdbc.spring.mapper.UserMapper;
import cn.puhy.shardingjdbc.spring.model.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author puhongyu
 * 2018/6/10 15:45
 */
public class MasterAndSlave {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("mybatisMasterSlaveOnlyContext.xml");
        UserMapper userMapper = applicationContext.getBean(UserMapper.class);

        System.out.println(userMapper.queryById(2));

        User user = new User();
        user.setName("王五");
        user.setAge(19);

        userMapper.insert(user);
    }
}
