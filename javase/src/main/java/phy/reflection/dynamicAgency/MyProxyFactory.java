package phy.reflection.dynamicAgency;

import java.lang.reflect.Proxy;

public class MyProxyFactory {
    
    //为指定的target生成动态代理对象
    public static Object getProxy(Object target) throws Exception {
        
        MyInvocationHandler handler = new MyInvocationHandler();
        //为MyInvocationHandler设置target对象
        handler.setTarget(target);
        //创建并返回一个动态代理
        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), handler);
    }
}
