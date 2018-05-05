package cn.puhy.designpattern.command;

/**
 * 调用者
 *
 * @author puhongyu
 * 2018/4/30 09:10
 */
public class Invoker {

    private Command command;
    //接收具体命令
    public void setCommand(Command command) {
        this.command = command;
    }
    //执行命令
    public void action() {
        command.execute();
    }
}
