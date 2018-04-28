package cn.puhy.designpattern.proxy;

/**
 * 代理
 *
 * @author puhongyu
 * 2018/4/21 18:14
 */
public class Proxy implements Subject {
    //要代理哪个实现类
    private Subject subject;

    public Proxy(Subject subject) {
        this.subject = subject;
    }

    public void request() {
        before();
        subject.request();
        after();
    }
    
    private void before() {
        System.out.println("前置处理");
    }

    private void after() {
        System.out.println("后置处理");
    }
}
