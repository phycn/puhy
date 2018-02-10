package phy.reflection.dynamicAgency;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class MyInvocationHandler implements InvocationHandler{
    
    private Object target;
    public void setTarget(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Exception {
        
        DogUtil du = new DogUtil();
        du.method1();
        //以target作为主调来执行method方法
        Object result = method.invoke(target, args);
        du.method2();
        
        return result;
    }
    
}
