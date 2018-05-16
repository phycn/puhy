package cn.puhy.designpattern.adapter;

/**
 * @author puhongyu
 * 2018/5/13 11:47
 */
public class Client {
    public static void main(String[] args) {
        //原有的业务逻辑
        Target target = new ConcreteTarget();
        target.request();

        //加入适配器后的业务逻辑
        Target target1 = new Adapter();
        target1.request();
    }
}
