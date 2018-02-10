package phy.jdk8;

public class Jdk8InterfaceTest {

    public static void main(String[] args) {
        // static方法必须通过接口类调用
        Jdk8Interface.staticMethod();
        ////default方法必须通过实现类的对象调用
        new Jdk8InterfaceImpl().defaultMethod();
    }
}

interface Jdk8Interface {
    static void staticMethod() {
        System.out.println("接口中的静态方法");
    }

    default void defaultMethod() {
        System.out.println("接口中的默认方法");
    }
}

class Jdk8InterfaceImpl implements Jdk8Interface {


}
