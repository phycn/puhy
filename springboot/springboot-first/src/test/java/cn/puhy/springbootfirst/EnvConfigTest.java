package cn.puhy.springbootfirst;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@SpringBootTest
@RunWith(SpringRunner.class)
public class EnvConfigTest {

    @Autowired
    private EnvConfig envConfig;

    @Test
    public void test() {
        System.out.println(envConfig.getProperty("user.dir"));
    }
}