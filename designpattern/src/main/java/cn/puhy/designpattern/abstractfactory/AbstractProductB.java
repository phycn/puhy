package cn.puhy.designpattern.abstractfactory;

/**
 * 抽象产品B
 *
 * @author puhongyu
 * 2018/4/11 17:46
 */
public abstract class AbstractProductB {

    //每个产品共有的方法
    public final void shareMethod() {
        System.out.println("产品A");
    }

    //每个产品相同方法，不同实现
    public abstract void doSomething();
}
