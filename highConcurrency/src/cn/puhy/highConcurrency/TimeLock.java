package cn.puhy.highConcurrency;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * tryLock方法
 * @author puhongyu
 *
 */
public class TimeLock implements Runnable {

	private static ReentrantLock lock = new ReentrantLock();
	@Override
	public void run() {
		try {
			//等待5秒的锁，超过5秒还没获得锁会返回false，tryLock没有参数则不会进行等待立即返回false
			if(lock.tryLock(5, TimeUnit.SECONDS)) {
				Thread.sleep(6000);
			}
			else {
				System.out.println("没有获得锁");
			}
		}
		catch(Exception e) {
			
		}
		finally {
			
		}
	}
	
	public static void main(String[] args) {
		TimeLock tl = new TimeLock();
		Thread t1 = new Thread(tl);
		Thread t2 = new Thread(tl);
		t1.start();
		t2.start();
	}
}
