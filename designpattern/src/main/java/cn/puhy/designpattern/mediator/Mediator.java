package cn.puhy.designpattern.mediator;

/**
 * 通用抽象中介者
 *
 * @author puhongyu
 * 2018/4/24 21:20
 */
public abstract class Mediator {

    protected ConcreteColleague1 concreteColleague1;
    protected ConcreteColleague2 concreteColleague2;

    public ConcreteColleague1 getConcreteColleague1() {
        return concreteColleague1;
    }

    public void setConcreteColleague1(ConcreteColleague1 concreteColleague1) {
        this.concreteColleague1 = concreteColleague1;
    }

    public ConcreteColleague2 getConcreteColleague2() {
        return concreteColleague2;
    }

    public void setConcreteColleague2(ConcreteColleague2 concreteColleague2) {
        this.concreteColleague2 = concreteColleague2;
    }

    //中介者的业务逻辑
    public abstract void dosomething1();
    public abstract void dosomething2();
}
