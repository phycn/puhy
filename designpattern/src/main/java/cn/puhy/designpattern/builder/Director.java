package cn.puhy.designpattern.builder;

/**
 * 导演类，避免高层模块深入到建造者内部的实现类
 *
 * @author puhongyu
 * 2018/4/18 13:59
 */
public class Director {

    private Builder builder = new ConcreteBuilder();

    //构建不同产品
    public Product getProductA() {
        builder.setPart();
        return builder.buildProduct();
    }

    public Product getProductB() {
        builder.setPart();
        return builder.buildProduct();
    }
}
