package cn.puhy.designpattern.strategy;

/**
 * @author puhongyu
 * 2018/5/12 09:52
 */
public class Client {
    public static void main(String[] args) {
        Strategy strategy1 = new ConcreteStrategy1();
        //这里换策略
        Context context = new Context(strategy1);
        context.doany();
    }
}
