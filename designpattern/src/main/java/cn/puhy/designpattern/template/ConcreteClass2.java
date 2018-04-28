package cn.puhy.designpattern.template;

/**
 * @author puhongyu
 * 2018/4/14 16:27
 */
public class ConcreteClass2 extends AbstractTemplate {
    protected void doSomething1() {
        System.out.println("具体模板类2的实现方法1");
    }

    protected void doSomething2() {
        System.out.println("具体模板类2的实现方法2");
    }
}
