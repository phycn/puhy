package cn.puhy.highConcurrency;

/**
 * volatile例子
 */
public class VolatileExample {
    private int x = 0;
    //这里不加volatile的话reader方法会永远循环下去
    private volatile boolean v = false;

    private void writer() {
        x = 42;
        v = true;
    }

    private void reader() {
        while (!v) {
//            System.out.println("111");
        }
        System.out.println("phyphy");

    }

    public static void main(String[] args) throws InterruptedException {
        final VolatileExample volatileExample = new VolatileExample();
        Thread thread = new Thread(volatileExample::reader);
        thread.start();
        Thread.sleep(1000);
        Thread thread2 = new Thread(volatileExample::writer);
        thread2.start();
    }
}