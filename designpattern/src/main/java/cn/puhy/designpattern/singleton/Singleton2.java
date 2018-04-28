package cn.puhy.designpattern.singleton;

/**
 * 懒汉式，线程安全，效率低下
 *
 * @author puhongyu
 * 2018/4/5 19:41
 */
public class Singleton2 {
    private static Singleton2 instance;

    private Singleton2() {

    }

    //加锁保证单例
    public static synchronized Singleton2 getInstance() {
        if (instance == null) {
            instance = new Singleton2();
        }
        return instance;
    }
}
