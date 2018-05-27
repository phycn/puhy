package cn.puhy.quartz.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author puhongyu
 * 2018/5/27 11:50
 */
public class SpringRunner {
    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("spring-quartz.xml");
    }
}
