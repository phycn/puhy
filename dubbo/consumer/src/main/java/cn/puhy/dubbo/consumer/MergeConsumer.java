package cn.puhy.dubbo.consumer;

import cn.puhy.dubbo.api.MergeService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * @author puhongyu
 * 2018/5/12 14:32
 */
public class MergeConsumer {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("consumer-merge-config.xml");
        context.start();
        MergeService mergeService = context.getBean(MergeService.class);
        List<String> list = mergeService.mergeResult();
        System.out.println("合并结果：" + list);
    }
}
