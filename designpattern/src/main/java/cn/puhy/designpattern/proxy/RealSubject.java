package cn.puhy.designpattern.proxy;

/**
 * 真实主题类
 *
 * @author puhongyu
 * 2018/4/21 18:13
 */
public class RealSubject implements Subject {
    public void request() {
        System.out.println("处理业务");
    }
}
