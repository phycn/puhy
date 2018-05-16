package cn.puhy.dubbo.provider;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author puhongyu
 * 2018/5/12 14:34
 */
public class MergeProvider {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("provider-merge-config.xml");
        context.start();
        while (true) {

        }
    }
}
