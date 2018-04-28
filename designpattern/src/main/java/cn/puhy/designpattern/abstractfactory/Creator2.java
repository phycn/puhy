package cn.puhy.designpattern.abstractfactory;

/**
 * 具体工厂类1
 *
 * @author puhongyu
 * 2018/4/11 18:00
 */
public class Creator2 extends AbstractCreator {
    //只生产产品等级为2的A产品
    public AbstractProductA createProductA() {
        return new ProductA2();
    }

    //只生产产品等级为2的B产品
    public AbstractProductB createProductB() {
        return new ProductB2();
    }
}
