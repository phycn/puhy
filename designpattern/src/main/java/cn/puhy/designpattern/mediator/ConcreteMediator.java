package cn.puhy.designpattern.mediator;

/**
 * 通用中介者
 *
 * @author puhongyu
 * 2018/4/24 21:34
 */
public class ConcreteMediator extends Mediator {
    public void dosomething1() {
        super.concreteColleague1.selfMethod1();
    }

    public void dosomething2() {
        super.concreteColleague2.selfMethod1();
    }
}
