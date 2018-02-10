package phy.annotation;

public class DeprecatedTest {
    
    //定义方法已过时
    @Deprecated
    public void oldMethod() {
        System.out.println("老方法");
    }
    
    public static void main(String[] args) {
        
        new DeprecatedTest().oldMethod();
    }
}
