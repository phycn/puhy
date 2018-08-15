package cn.puhy.jvm.classload;

/**
 * 引用final常量不会引起类的初始化
 *
 * @author puhongyu
 * 2018/4/14 22:35
 */
public class ClassLoadExample2 {
    public static void main(String[] args) {
        System.out.println(FinalField.a);
    }
}

class FinalField {
    static final String a = "final";

    static {
        System.out.println("FinalField init");
    }
}
