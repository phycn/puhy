package cn.puhy.mymvc.service;

import cn.puhy.mymvc.annotiion.Service;

@Service("myService")
public class MyServiceImpl implements MyService {
    public boolean insert() {
        System.out.println("MyServiceImpl>调用insert 方法");
        return true;
    }
}
