package cn.puhy.zookeeper;

/**
 * @author puhongyu
 * 2018/4/28 21:42
 */
public class DistributeLockTest implements Runnable {
    private static int i = 0;

    private DistributeLock lock = new DistributeLock("localhost:2181,localhost:2182,localhost:2183", "/lock");

    @Override
    public void run() {
        lock.lock();
        for (int j = 0; j < 1000000; j++) {
            i++;
        }
        lock.unlock();
    }

    public static void main(String[] args) throws InterruptedException {
        DistributeLockTest lockTest = new DistributeLockTest();
        Thread thread = new Thread(lockTest);
        Thread thread2 = new Thread(lockTest);
        thread.start();
        thread2.start();
        thread.join();
        thread2.join();
        System.out.println(i);
    }
}
