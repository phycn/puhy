package cn.puhy.designpattern.template;

/**
 * @author puhongyu
 * 2018/4/14 16:23
 */
public abstract class AbstractTemplate {
    //基本方法1
    protected abstract void doSomething1();

    //基本方法1
    protected abstract void doSomething2();

    //模板方法
    public final void templateMethod() {
        //为true才执行doSomething1
        if (isDoSomething1()) {
            doSomething1();
        }
        doSomething2();
    }

    //钩子方法，默认是true
    protected boolean isDoSomething1() {
        return true;
    }
}
