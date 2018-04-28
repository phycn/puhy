package cn.puhy.highConcurrency;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 响应中断锁处理死锁
 * @author puhongyu
 *
 */
public class InterruptLock implements Runnable {
	
	private static ReentrantLock lock1 = new ReentrantLock();
	private static ReentrantLock lock2 = new ReentrantLock();
	
	private int lockNum;
	public InterruptLock(int lockNum) {
		this.lockNum = lockNum;
	}
	
	@Override
	public void run() {
		try {
			//构造死锁
			if(lockNum == 1) {
				//响应中断的锁
				lock1.lockInterruptibly();
				Thread.sleep(1000);
				lock2.lockInterruptibly();
			}
			else {
				lock2.lockInterruptibly();
				Thread.sleep(1000);
				lock1.lockInterruptibly();
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			if(lock1.isHeldByCurrentThread()) {
				lock1.unlock();
			}
			if(lock2.isHeldByCurrentThread()) {
				lock2.unlock();
			}
			System.out.println(Thread.currentThread().getName() + "退出");
		}
	}
	
	public static void main(String[] args) throws InterruptedException {
		InterruptLock l1 = new InterruptLock(1);
		InterruptLock l2 = new InterruptLock(2);
		Thread t1 = new Thread(l1);
		Thread t2 = new Thread(l2);
		t1.start();
		t2.start();
		Thread.sleep(5000);
		//中断其中一个线程
		t2.interrupt();
	}
}
