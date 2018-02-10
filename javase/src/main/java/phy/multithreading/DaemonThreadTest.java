package phy.multithreading;

public class DaemonThreadTest extends Thread {

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            System.out.println(getName() + " " + i);
        }
    }

    public static void main(String[] args) {

        DaemonThreadTest d = new DaemonThreadTest();
        //将线程设置成后台线程
        d.setDaemon(true);
        d.start();
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName());
        }
        //运行到此处，main线程结束，后台线程也应该随之结束
    }
}
