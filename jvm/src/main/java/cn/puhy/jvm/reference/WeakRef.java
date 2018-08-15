package cn.puhy.jvm.reference;

import java.lang.ref.WeakReference;

/**
 * 弱引用，GC时都会回收
 *
 * @author puhongyu
 * 2018/6/19 15:46
 */
public class WeakRef {
    public static void main(String[] args) {
        User user = new User(2, "蒲红宇");
        WeakReference<User> weakReference = new WeakReference<>(user);
        user = null;

        System.out.println(weakReference.get());
        //不管当前内存空间足够与否，都会回收
        System.gc();
        System.out.println("after gc");
        System.out.println(weakReference.get());
    }
}
