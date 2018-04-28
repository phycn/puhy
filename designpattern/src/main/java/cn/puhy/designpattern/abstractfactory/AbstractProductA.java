package cn.puhy.designpattern.abstractfactory;

/**
 * 抽象产品A
 *
 * @author puhongyu
 * 2018/4/11 17:46
 */
public abstract class AbstractProductA {

    //每个产品共有的方法
    public final void shareMethod() {
        System.out.println("产品A");
    }

    //每个产品相同方法，不同实现
    public abstract void doSomething();
}
