package cn.puhy.highConcurrency;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 公平锁，先到先得，性能较差
 * @author puhongyu
 *
 */
public class FairLock implements Runnable {
	
	//公平锁
	private static ReentrantLock fairLock = new ReentrantLock(true);

	@Override
	public void run() {
		try {
//			while(true) {
				fairLock.lock();
				System.out.println(Thread.currentThread().getName() + " 获得锁");
//				Thread.sleep(1000);
//			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			fairLock.unlock();
		}
	}
	
	public static void main(String[] args) throws InterruptedException {
		FairLock fl = new FairLock();
		Thread t1 = new Thread(fl, "线程1");
		Thread t2 = new Thread(fl, "线程2");
		Thread t3 = new Thread(fl, "线程3");
		t2.start();
		t1.start();
		t3.start();
	}
}
