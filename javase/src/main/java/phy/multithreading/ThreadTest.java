package phy.multithreading;

public class ThreadTest extends Thread {

    private int i;
    
    //线程执行体
    @Override
    public void run() {
        for (; i < 10; i++) {
            System.out.println(getName() + " " + i);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        // TODO 自动生成的方法存根
        for (int i = 0; i < 10; i++) {
            //获取当前线程名称
            System.out.println(Thread.currentThread().getName() + " " + i);
            if (i == 2) {
                //启动线程
                new ThreadTest().start();
                new ThreadTest().start();
            }
        }
    }
}
