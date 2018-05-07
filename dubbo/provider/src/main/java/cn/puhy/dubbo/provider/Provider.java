package cn.puhy.dubbo.provider;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author puhongyu
 * 2018/5/6 09:11
 */
public class Provider {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("provider-config.xml");
        context.start();
        System.out.println("provider start");
        while (true) {

        }
    }
}
