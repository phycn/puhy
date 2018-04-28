package cn.puhy.designpattern.singleton;

/**
 * 懒汉式，线程不安全
 *
 * @author puhongyu
 * 2018/4/5 19:32
 */
public class Singleton1 {
    private static Singleton1 instance;

    private Singleton1() {

    }

    public static Singleton1 getInstance() {
        if (instance == null) {
            instance = new Singleton1();
        }
        return instance;
    }
}
