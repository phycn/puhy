package cn.puhy.designpattern.singleton;

/**
 * 双重锁
 *
 * @author puhongyu
 * 2018/4/5 19:52
 */
public class Singleton4 {
    //volatile防止指令重排序
    private volatile static Singleton4 instance;

    private Singleton4() {

    }

    public static Singleton4 getInstance() {
        if (instance == null) {
            synchronized (Singleton4.class) {
                if (instance == null) {
                    instance = new Singleton4();
                }
            }
        }
        return instance;
    }
}
