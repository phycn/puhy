package cn.puhy.highConcurrency;

import java.util.concurrent.locks.ReentrantLock;

public class ReenterLock extends Thread {
	private static ReentrantLock lock = new ReentrantLock();
	private static int i = 0;
	
	public void run() {
		for(int j = 0; j < 1000000; j++) {
			//加锁
			lock.lock();
			i++;
			//解锁
			lock.unlock();
		}
	}
	
	public static void main(String[] args) throws InterruptedException {
		ReenterLock rl = new ReenterLock();
		Thread r1 = new Thread(rl);
		Thread r2 = new Thread(rl);
		r1.start();
		r2.start();
		r1.join();
		r2.join();
		System.out.println(i);
	}
}
