package cn.puhy.jvm.reference;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;

/**
 * 软引用，堆内存不足时被回收
 * JVM参数：-Xms10m -Xmx10m
 *
 * @author puhongyu
 * 2018/6/19 14:26
 */
public class SoftRef {

    //引用队列，被回收的软引用对象进入队列
    private static ReferenceQueue<User> queue = new ReferenceQueue<>();

    public static void main(String[] args) throws InterruptedException {
        User user = new User(1, "蒲红宇");

        //软引用
        SoftReference<User> softReference = new SoftReference<>(user, queue);
        user = null;

        System.out.println(softReference.get());
        System.gc();
        System.out.println("1after gc: ");
        System.out.println(softReference.get());

        byte[] bytes = new byte[1024 * 969 * 7];
        //堆内存不足时被回收了
        System.gc();
        System.out.println("2after gc: ");
        System.out.println(softReference.get());
        
        System.out.println(queue.remove());
    }
}


