package cn.puhy.designpattern.factory;

/**
 * @author puhongyu
 * 2018/4/8 23:04
 */
public class Client {
    public static void main(String[] args) {
        try {
            //由工厂类生产产品1
            Product product1 = Factory.getProduct(Product1.class);
            product1.method2();
            //由工厂类生产产品2
            Product product2 = Factory.getProduct(Product2.class);
            product2.method2();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
    }
}
