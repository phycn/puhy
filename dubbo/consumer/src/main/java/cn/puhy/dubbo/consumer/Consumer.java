package cn.puhy.dubbo.consumer;

import cn.puhy.dubbo.api.FirstService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author puhongyu
 * 2018/5/6 09:28
 */
public class Consumer {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("consumer-config.xml");
        context.start();
        FirstService firstService = (FirstService) context.getBean("firstService");
        firstService.sayHello("蒲红宇");
        while (true) {

        }
    }
}
