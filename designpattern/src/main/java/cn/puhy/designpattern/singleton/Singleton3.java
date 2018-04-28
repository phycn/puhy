package cn.puhy.designpattern.singleton;

/**
 * 恶汉式，没有懒加载
 *
 * @author puhongyu
 * 2018/4/5 19:44
 */
public class Singleton3 {

    private static Singleton3 instance;

    private Singleton3() {

    }

    public static Singleton3 getInstance() {
        return instance;
    }
}
