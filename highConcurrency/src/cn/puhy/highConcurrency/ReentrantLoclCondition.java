package cn.puhy.highConcurrency;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLoclCondition implements Runnable {

	private static ReentrantLock lock = new ReentrantLock();
	private static Condition condition = lock.newCondition();
	
	@Override
	public void run() {
		try {
			lock.lock();
			//当前线程等待，释放锁
			condition.await();
			System.out.println("继续执行");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			lock.unlock();
		}
	}
	
	public static void main(String[] args) throws InterruptedException {
		ReentrantLoclCondition rlc = new ReentrantLoclCondition();
		Thread t1 = new Thread(rlc);
		t1.start();
		Thread.sleep(1000);
		//必须先获得锁
		lock.lock();
		//唤醒等待中的线程
		condition.signalAll();
		lock.unlock();
	}
}
