//封装处理行为

package phy.oop.command;

public interface Command {
    
    //处理数组，具体实现在实现类
    void process(int[] array);
}
