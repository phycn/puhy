package cn.puhy.designpattern.factory;

/**
 * 工厂类
 *
 * @author puhongyu
 * 2018/4/8 22:59
 */
public class Factory {
    public static <T extends Product> T getProduct(Class<T> tClass) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        Product product = (Product) Class.forName(tClass.getName()).newInstance();
        return (T) product;
    }
}
