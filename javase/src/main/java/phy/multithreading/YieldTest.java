package phy.multithreading;

public class YieldTest implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName() + " " + i);
            if (i == 20) {
                Thread.yield();
            }
        }
    }

    public static void main(String[] args) {

        YieldTest yt1 = new YieldTest();
        Thread t1 = new Thread(yt1, "线程一");
        t1.setPriority(Thread.MIN_PRIORITY);
        t1.start();

        YieldTest yt2 = new YieldTest();
        Thread t2 = new Thread(yt2, "线程二");
        t2.setPriority(Thread.MAX_PRIORITY);
        t2.start();
    }
}
