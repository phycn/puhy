package cn.puhy.highConcurrency.lock;

import java.util.concurrent.atomic.AtomicIntegerArray;

/**
 * 无锁的数组
 * @author puhongyu
 *
 */
public class AtomicIntegerArrayDemo {
	
	private static AtomicIntegerArray arr = new AtomicIntegerArray(10);
	
	private static class Add implements Runnable {

		@Override
		public void run() {
			for(int i = 0; i < 100; i++) {
				//下标为i % arr.length()的元素加1
				arr.getAndIncrement(i % arr.length());
			}
		}
	}
	
	public static void main(String[] args) throws InterruptedException {
		
		for(int i = 0; i < 10; i++) {
			Thread t = new Thread(new Add());
			t.start();
			t.join();
		}
		
		System.out.println(arr);
	}
}
