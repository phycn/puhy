package cn.puhy.designpattern.decorator;

/**
 * @author puhongyu
 * 2018/5/8 06:59
 */
public class Client {
    public static void main(String[] args) {
        Component component = new ConcreteComponent();
        component = new ConcreteDecorator1(component);
//        component.doSomething();

        component = new ConcreteDecorator2(component);
        component.doSomething();
    }
}
