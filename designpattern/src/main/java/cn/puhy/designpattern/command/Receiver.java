package cn.puhy.designpattern.command;

/**
 * 命令接收者，也就是执行具体命令的
 *
 * @author puhongyu
 * 2018/4/30 08:55
 */
public abstract class Receiver {
    //具体接收者需要完成的任务
    public abstract void dosomething();
}
