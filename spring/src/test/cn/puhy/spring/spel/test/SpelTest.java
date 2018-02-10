package cn.puhy.spring.spel.test;

import cn.puhy.spring.spel.AnnotationSpel;
import cn.puhy.spring.spel.PropertyBean;
import cn.puhy.spring.spel.User;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpelTest {

    private static ClassPathXmlApplicationContext ctx;

    @BeforeClass
    public static void init() {
        ctx = new ClassPathXmlApplicationContext("cn/puhy/spring/spel/spel.xml");
    }

    @Test
    public void test1() {
        User user = (User) ctx.getBean("user");
        System.out.println(user.getRandomNum());
    }

    @Test
    public void test2() {
        PropertyBean bean = ctx.getBean("propertyBean", PropertyBean.class);
        System.out.println(bean.getOsName());
    }

    @Test
    public void test3() {
        AnnotationSpel as = ctx.getBean(AnnotationSpel.class);
        System.out.println(as.getName());
        System.out.println(as.getAge());
    }
}
