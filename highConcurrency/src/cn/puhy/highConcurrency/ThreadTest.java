package cn.puhy.highConcurrency;

import java.util.Random;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadTest {
    private String name;

    // ReentrantLock reentrantLock=new ReentrantLock();
    public static void main(String[] args) throws InterruptedException {
        ThreadTest t = new ThreadTest();
        t.runTest();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void runTest() throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            final int j = i;
            new Thread(new Runnable() {
                @Override
                public void run() {
                    //不加锁执行结果会一样
                    //reentrantLock.lock();
                    synchronized (ThreadTest.class) {
                        String name = "phy" + j;
                        setName(name);
                        try {
                            Thread.sleep(1000);
                            System.out.println(Thread.currentThread().getName() + ":" + getName());
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        } finally {
                            //reentrantLock.unlock();
                        }
                    }
                }
            }).start();
        }
    }
}
