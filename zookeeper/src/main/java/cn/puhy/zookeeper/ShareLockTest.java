package cn.puhy.zookeeper;

import java.util.Random;

/**
 * @author puhongyu
 * 2018/4/29 18:37
 */
public class ShareLockTest implements Runnable {

    private ShareLock shareLock = new ShareLock("localhost:2181,localhost:2182,localhost:2183", "phy");

    @Override
    public void run() {
        shareLock.lock();
        System.out.println(Thread.currentThread().getName() +"获得了锁");
        shareLock.unLock();
    }

    public static void main(String[] args) throws InterruptedException {
        Random random = new Random();
        for (int i = 0; i < 20; i++) {
            ShareLockTest shareLockTest = new ShareLockTest();
            Thread thread = new Thread(shareLockTest);
            thread.start();
            Thread.sleep(random.nextInt(10));
            thread.join();
        }
    }
}
