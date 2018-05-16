package cn.puhy.springmybatis;

import cn.puhy.springmybatis.bean.User;
import cn.puhy.springmybatis.mapper.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author puhongyu
 * 2018/5/15 06:53
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class MyBatisTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void test() {
        User user = userMapper.queryById(1);
        System.out.println(user);
    }
}
