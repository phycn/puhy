package cn.puhy.designpattern.command;

/**
 * 具体接收者1
 *
 * @author puhongyu
 * 2018/4/30 08:57
 */
public class ConcreteReceiver1 extends Receiver {
    public void dosomething() {
        System.out.println("1完成的任务");
    }
}
