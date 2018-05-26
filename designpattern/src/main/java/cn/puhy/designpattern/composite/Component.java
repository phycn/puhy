package cn.puhy.designpattern.composite;

import java.util.List;

/**
 * 抽象组件
 *
 * @author puhongyu
 * 2018/5/24 13:17
 */
public abstract class Component {
    //
    public void doSomething() {
        //业务逻辑
    }

    //增加一个子组件
    public abstract void add(Component component);

    //删除一个子组件
    public abstract void remove(Component component);

    //获得分支下的所有子组件
    public abstract List<Component> getChildren();
}
