package cn.puhy.jvm.classload;

/**
 * 子类没有被初始化
 *
 * @author puhongyu
 * 2018/4/14 22:20
 */
public class ClassLoadExample1 {
    public static void main(String[] args) {
        //Child不会被初始化没有被调用自己的静态字段
        System.out.println(Child.a);
        //有被调用了自己的静态字段，会先初始化
        System.out.println(Child.b);
    }
}

class Parent {
    static int a = 100;

    static {
        System.out.println("parent init");
    }
}

class Child extends Parent {
    static int b = 200;
    static {
        System.out.println("child init");
    }
}
