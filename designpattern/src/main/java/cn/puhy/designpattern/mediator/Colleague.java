package cn.puhy.designpattern.mediator;

/**
 * 抽象同事类
 *
 * @author puhongyu
 * 2018/4/24 21:21
 */
public abstract class Colleague {

    protected Mediator mediator;

    public Colleague(Mediator mediator) {
        this.mediator = mediator;
    }
}
