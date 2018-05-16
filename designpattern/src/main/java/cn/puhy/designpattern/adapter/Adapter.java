package cn.puhy.designpattern.adapter;

/**
 * 适配器，适配源角色和目标角色
 *
 * @author puhongyu
 * 2018/5/13 11:45
 */
public class Adapter extends Adaptee implements Target {
    @Override
    public void request() {
        super.dosomething();
    }
}
