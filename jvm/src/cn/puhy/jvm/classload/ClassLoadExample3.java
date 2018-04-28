package cn.puhy.jvm.classload;

/**
 * 类初始化死锁
 *
 * @author puhongyu
 * 2018/4/15 10:24
 */
public class ClassLoadExample3 extends Thread {

    private String flag;

    public ClassLoadExample3(String flag) {
        this.flag = flag;
        this.setName("thread:" + flag);
    }

    @Override
    public void run() {
        try {
            Class.forName("cn.puhy.jvm.classload.Static" + flag);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println(getName() + " over");
    }

    public static void main(String[] args) {
        ClassLoadExample3 classLoadExample31 = new ClassLoadExample3("A");
        classLoadExample31.start();
        ClassLoadExample3 classLoadExample32 = new ClassLoadExample3("B");
        classLoadExample32.start();
    }
}

class StaticA {
    static {
        try {
            Thread.sleep(1000);
            Class.forName("cn.puhy.jvm.classload.StaticB");
        } catch (InterruptedException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println("A inti ok");
    }
}

class StaticB {
    static {
        try {
            Thread.sleep(1000);
            Class.forName("cn.puhy.jvm.classload.StaticA");
        } catch (InterruptedException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println("B inti ok");
    }
}
