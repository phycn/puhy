package cn.puhy.dubbo.provider.service;

import cn.puhy.dubbo.api.FirstService;

/**
 * @author puhongyu
 * 2018/5/6 08:58
 */
public class FirstServiceImpl implements FirstService {
    @Override
    public void sayHello(String name) {
        System.out.println("你好呀！" + name);
    }
}
