package cn.puhy.designpattern.mediator;

/**
 * 具体同事类2
 *
 * @author puhongyu
 * 2018/4/24 21:23
 */
public class ConcreteColleague2 extends Colleague {
    public ConcreteColleague2(Mediator mediator) {
        super(mediator);
    }

    //自有方法，处理自己的业务逻辑
    public void selfMethod1() {
        System.out.println("同事类2的自有方法1");
    }

    public void depMethod1() {
        super.mediator.dosomething1();
    }
}
