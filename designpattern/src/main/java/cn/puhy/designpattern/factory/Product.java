package cn.puhy.designpattern.factory;

/**
 * 产品类
 *
 * @author puhongyu
 * 2018/4/8 22:55
 */
public abstract class Product {
    //产品类的公共方法
    public void method1() {
        System.out.println("业务逻辑处理");
    }

    //抽象方法
    public abstract void method2();
}
