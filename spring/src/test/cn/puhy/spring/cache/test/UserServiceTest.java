package cn.puhy.spring.cache.test;

import cn.puhy.spring.cache.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author puhongyu
 * 2018/5/26 13:54
 */
@ContextConfiguration(locations = { "classpath:cn/puhy/spring/cache/cache.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
public class UserServiceTest {

    @Autowired
    private UserService userService;

    @Test
    public void cacheableTest() throws InterruptedException {
        System.out.println(userService.getUser(1));
        System.out.println(userService.getUser(1));
        //3不会被缓存，因为不满足条件
        System.out.println(userService.getUser(3));
        System.out.println(userService.getUser(3));
    }

    @Test
    public void cacheputTest() throws InterruptedException {
        userService.getUserPut(1);
        //还是会执行方法
        userService.getUserPut(1);
        //这里就直接从缓存中获取
        System.out.println(userService.getUser(1));
    }

    @Test
    public void cacheEvictTest() throws InterruptedException {
        userService.getUser(1);
        userService.removeUser(1);
        userService.getUser(1);
    }
}
