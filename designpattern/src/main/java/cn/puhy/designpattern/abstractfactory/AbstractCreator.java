package cn.puhy.designpattern.abstractfactory;

/**
 * 抽象工厂
 *
 * @author puhongyu
 * 2018/4/11 17:58
 */
public abstract class AbstractCreator {
    //创建产品A族
    public abstract AbstractProductA createProductA();
    //创建产品B族
    public abstract AbstractProductB createProductB();
}
