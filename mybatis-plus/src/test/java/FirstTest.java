import cn.puhy.mybatisplus.FirstApplication;
import cn.puhy.mybatisplus.first.User;
import cn.puhy.mybatisplus.first.UserMapper;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author PUHY
 * 2018-11-20 22:34
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {FirstApplication.class})
public class FirstTest {

    @Resource
    private UserMapper userMapper;

    @Test
    public void testSelect() {
        System.out.println(("----- selectAll method test ------"));
        List<User> userList = userMapper.selectList(null);
        Assert.assertEquals(5, userList.size());
        userList.forEach(System.out::println);
    }
}
