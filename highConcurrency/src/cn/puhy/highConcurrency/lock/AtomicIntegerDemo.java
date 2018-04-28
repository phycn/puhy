package cn.puhy.highConcurrency.lock;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 线程安全的无锁整数：AtomicInteger
 * CAS操作
 * @author puhongyu
 *
 */
public class AtomicIntegerDemo {
	private static AtomicInteger i = new AtomicInteger(100);
	
	private static class AddThread implements Runnable {

		@Override
		public void run() {
			for(int j = 0; j < 100000; j++) {
				//当前值加1
				i.incrementAndGet();
			}
		}
	}
	
	public static void main(String[] args) throws InterruptedException {
		AddThread at1 = new AddThread();
		AddThread at2 = new AddThread();
		
		Thread t1 = new Thread(at1);
		Thread t2 = new Thread(at2);
		
		t1.start();
		t2.start();
		
		t1.join();
		t2.join();
		
		System.out.println(i.get());
	}
}
