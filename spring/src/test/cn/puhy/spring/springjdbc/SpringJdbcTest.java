package cn.puhy.spring.springjdbc;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:cn/puhy/spring/springjdbc/springjdbc.xml")
public class SpringJdbcTest {

    @Autowired
    private UserDao userDao;

    @Test
    public void updateTest() {
        userDao.update();
    }

    @Test
    public void insertTest() {
        userDao.insert();
    }

    @Test
    public void batchInsertTest() {
        userDao.batchInsert();
    }
}
