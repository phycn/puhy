package cn.puhy.jvm;

/**
 * @author puhongyu
 * 2018/4/17 19:59
 */
public class GcLog {
    public static void main(String[] args) {
        byte[] a = new byte[6 * 1024 * 1024];
        a = null;
        System.gc();

        byte[] b = new byte[6 * 1024 * 1024];
        System.gc();
    }
}
