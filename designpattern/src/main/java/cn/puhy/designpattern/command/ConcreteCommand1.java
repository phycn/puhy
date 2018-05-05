package cn.puhy.designpattern.command;

/**
 * 具体命令1
 *
 * @author puhongyu
 * 2018/4/30 09:07
 */
public class ConcreteCommand1 extends Command {

    private Receiver receiver;

    //构造函数传递接收者
    public ConcreteCommand1(Receiver receiver) {
        this.receiver = receiver;
    }

    public void execute() {
        //具体由接收者执行
        receiver.dosomething();
    }
}
