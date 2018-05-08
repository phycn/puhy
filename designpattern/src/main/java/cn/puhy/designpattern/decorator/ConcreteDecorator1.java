package cn.puhy.designpattern.decorator;

/**
 * 具体装饰器
 * @author puhongyu
 * 2018/5/8 06:54
 */
public class ConcreteDecorator1 extends Decorator {
    public ConcreteDecorator1(Component component) {
        super(component);
    }

    @Override
    public void doSomething() {
        decoratorMethod();
        super.doSomething();
    }

    //定义自己的修饰方法
    private void decoratorMethod() {
        System.out.println("ConcreteDecorator1 修饰");
    }
}
