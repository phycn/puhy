package cn.puhy.designpattern.command;

/**
 * @author puhongyu
 * 2018/4/30 09:12
 */
public class Client {
    public static void main(String[] args) {
        //调用者，相当于项目经理
        Invoker invoker = new Invoker();
        //接收者，相当于程序员
        Receiver receiver1 = new ConcreteReceiver1();
        //命令，相当于需求，由指定程序员完成，这里最好的做法是由其他类指定具体程序员，而不是由命令来指定
        Command command1 = new ConcreteCommand1(receiver1);
        //项目经理安排程序员
        invoker.setCommand(command1);
        //项目经理下达命令
        invoker.action();
    }
}
