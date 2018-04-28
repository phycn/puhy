package cn.puhy.designpattern.template;

/**
 * @author puhongyu
 * 2018/4/14 16:28
 */
public class Client {
    public static void main(String[] args) {
        AbstractTemplate t1 = new ConcreteClass1();
        AbstractTemplate t2 = new ConcreteClass2();

        t1.templateMethod();
        t2.templateMethod();
    }
}
