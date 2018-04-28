package cn.puhy.highConcurrency;

import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 读写分离锁
 * @author puhongyu
 *
 */
public class ReadWriteLockDemo {

	private static ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();
	//读锁
	private static Lock readLock = readWriteLock.readLock();
	//写锁
	private static Lock writeLock = readWriteLock.writeLock();
	private int num = 0;
	
	/**
	 * 读操作
	 * @param lock
	 * @return
	 * @throws InterruptedException
	 */
	private int handleRead(Lock lock) throws InterruptedException {
		
		lock.lock();
		//模拟业务流程
		Thread.sleep(1000);
		lock.unlock();
		return num;
	}
	
	/**
	 * 写操作
	 * @param lock
	 * @param value
	 * @throws InterruptedException
	 */
	private void handleWrite(Lock lock, int value) throws InterruptedException {
		
		lock.lock();
		//模拟业务流程
		Thread.sleep(1000);
		num = value;
		lock.unlock();
	}
	
	public static void main(String[] args) {
		ReadWriteLockDemo demo = new ReadWriteLockDemo();
		
		Runnable readRunnable = new Runnable() {

			@Override
			public void run() {
				try {
					//读锁不会阻塞，18个线程并行
					System.out.println(demo.handleRead(readLock));
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		};
		
		Runnable writeRunnable = new Runnable() {

			@Override
			public void run() {
				try {
					demo.handleWrite(writeLock, new Random().nextInt());
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		};
		
		for(int i = 0; i < 18; i++) {
			new Thread(readRunnable).start();
		}
		for(int i = 18; i < 20; i++) {
			new Thread(writeRunnable).start();
		}
	}
}
