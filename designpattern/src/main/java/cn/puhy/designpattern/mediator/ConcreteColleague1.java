package cn.puhy.designpattern.mediator;

/**
 * 具体同事类1
 *
 * @author puhongyu
 * 2018/4/24 21:23
 */
public class ConcreteColleague1 extends Colleague {
    public ConcreteColleague1(Mediator mediator) {
        super(mediator);
    }

    //自有方法，处理自己的业务逻辑
    public void selfMethod1() {
        System.out.println("同事类1的自有方法1");
    }

    public void depMethod1() {
        //自己不能处理的交给中介者处理
        super.mediator.dosomething2();
    }
}
