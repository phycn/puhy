package cn.puhy.designpattern.builder;

/**
 * @author puhongyu
 * 2018/4/18 13:57
 */
public class ConcreteBuilder extends Builder {

    private Product product = new Product();
    //设置产品零件
    public void setPart() {

    }
    //组建一个产品
    public Product buildProduct() {
        return product;
    }
}
