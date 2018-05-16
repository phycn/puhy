package cn.puhy.designpattern.adapter;

/**
 * 具体目标角色
 *
 * @author puhongyu
 * 2018/5/13 11:43
 */
public class ConcreteTarget implements Target {
    @Override
    public void request() {
        System.out.println("具体目标角色方法");
    }
}
