package cn.puhy.springbootfirst;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author puhongyu
 * 2018/5/24 21:12
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class ConditionalTest {

    @Autowired
    private BeanConditional beanConditional;

    @Autowired
    private ClassConditional classConditional;

    @Autowired
    private EnvConditional envConditional;

    @Test
    public void beanConditionalTest() {
        Assert.assertNotNull(beanConditional);
    }

    @Test
    public void classConditionalTest() {
        Assert.assertNotNull(classConditional);
    }

    @Test
    public void envConditionalTest() {
        Assert.assertNotNull(envConditional);
    }
}
