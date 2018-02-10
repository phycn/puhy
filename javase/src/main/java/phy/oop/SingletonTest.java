package phy.oop;

public class SingletonTest {
   
    public static void main(String ... args) {
        
        //创建Singleton对象不能通过构造器
        Singleton a = Singleton.getInstance();
        Singleton b = Singleton.getInstance();
        
        //输出true
        System.out.println(a == b);
    }
}

class Singleton {
    
    //缓存曾经创建的实例
    private static Singleton singleton;
    
    //隐藏构造器
    private Singleton() {}
    
    //该方法保证只产生一个对象
    public static Singleton getInstance() {
        
        if(singleton == null) {
            singleton = new Singleton();
        }
        return singleton;
    }
}
