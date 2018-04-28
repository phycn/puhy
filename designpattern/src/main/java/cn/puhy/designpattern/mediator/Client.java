package cn.puhy.designpattern.mediator;

/**
 * @author puhongyu
 * 2018/4/24 21:41
 */
public class Client {
    public static void main(String[] args) {
        Mediator mediator = new ConcreteMediator();
        ConcreteColleague1 colleague1 = new ConcreteColleague1(mediator);
        ConcreteColleague2 colleague2 = new ConcreteColleague2(mediator);

        mediator.setConcreteColleague1(colleague1);
        mediator.setConcreteColleague2(colleague2);

        colleague1.selfMethod1();
        //自己不能处理将会交给中介者去处理
        colleague1.depMethod1();
    }
}
