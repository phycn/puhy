package phy.oop;

public class OverloadTest {
    
    //方法名相同，方法的形参列表不同，就称为方法重载
    public void test() {
        System.out.println("无参数的test方法");
    }
    
    public void test(String str) {
        System.out.println("有参数的test方法");
    }
    
    public void test(String ... args) {
        System.out.println("形参长度可变的test方法");
    }
    
    public static void main(String ... args) {
        
        OverloadTest o = new OverloadTest();
        o.test();
        //调用的是第2个test方法
        o.test("1");
        //调用第3个test方法，这个方法不包括一个形参的情况
        o.test("1","3");
    }
}
