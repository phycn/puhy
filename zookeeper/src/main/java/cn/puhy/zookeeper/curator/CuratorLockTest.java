package cn.puhy.zookeeper.curator;

/**
 * @author puhongyu
 * 2018/5/1 13:28
 */
public class CuratorLockTest implements Runnable {
    private static int i = 0;
    private CuratorLock lock = new CuratorLock("/curator");
    CuratorCrud crud = new CuratorCrud();
    @Override
    public void run() {
        try {
            lock.acquire();
            crud.setData("/curator", Thread.currentThread().getName().getBytes());
            for (int j = 0; j < 100000; j++) {
                i++;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                lock.release();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        CuratorLockTest c1 = new CuratorLockTest();
        Thread t1 = new Thread(c1);
        CuratorLockTest c2 = new CuratorLockTest();
        Thread t2 = new Thread(c2);
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(i);
    }
}
