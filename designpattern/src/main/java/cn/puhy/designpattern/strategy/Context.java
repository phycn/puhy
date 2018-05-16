package cn.puhy.designpattern.strategy;

/**
 * @author puhongyu
 * 2018/5/12 09:50
 */
public class Context {
    private Strategy strategy;
    //构造函数设置具体策略
    public Context(Strategy strategy) {
        this.strategy = strategy;
    }

    public void doany() {
        strategy.dosomething();
    }
}
