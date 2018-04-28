package cn.puhy.designpattern.singleton;

/**
 * 静态内部类单例模式，类加载机制保证线程安全
 *
 * @author puhongyu
 * 2018/4/5 20:19
 */
public class Singleton5 {

    private static class SingletonHolder {
        private static final Singleton5 instance = new Singleton5();
    }

    private Singleton5() {

    }

    public static Singleton5 getInstance() {
        return SingletonHolder.instance;
    }
}
