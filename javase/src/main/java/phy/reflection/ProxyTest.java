package phy.reflection;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

interface Person1 {
    
    void walk();
    void sayHello(String name);
}

class MyInvocationHandler implements InvocationHandler {

    @Override
    //执行动态代理对象的所有方法时，都会被替换成执行如下的invoke方法
    //proxy：代表动态代理对象
    //method：代表正在执行的方法
    //args：代表调用目标方法时传入的实参
    public Object invoke(Object proxy, Method method, Object[] args) {
        
        System.out.println("正在执行的方法：" + method);
        if(args != null) {
            
            System.out.print("执行该方法的实参：");
            for(Object val : args) {
                
                System.out.println(val);
            }
        }
        else {
            System.out.println("该方法没有实参");
        }
        return null;
    }
    
}

public class ProxyTest {
    
    public static void main(String[] args) {
        
        //创建一个InvocationHandler对象
        InvocationHandler handler = new MyInvocationHandler();
        //生成Person1的动态代理对象
        Person1 p = (Person1)Proxy.newProxyInstance(Person.class.getClassLoader(), new Class[]{Person1.class}, handler);
        p.walk();
        p.sayHello("蒲红宇");
    }
}
