package cn.puhy.highConcurrency;

import java.util.concurrent.locks.LockSupport;

/**
 * LockSupport线程阻塞工具类，不会抛出InterruptedException异常
 * @author puhongyu
 *
 */
public class LockSupportDemo {
	private static Object o = new Object();
	
	private static class ChangeObject extends Thread {
		ChangeObject(String name) {
			super.setName(name);
		}
		
		public void run() {
			synchronized (o) {
				System.out.println(" " + getName());
				//阻塞当前线程
				LockSupport.park();
				if(Thread.interrupted()) {
					System.out.println(getName() + "被中断了");
				}
				System.out.println(getName() + "完成");
			}
		}
	}
	
	public static void main(String[] args) throws InterruptedException {
		
		ChangeObject co1 = new ChangeObject("one");
		ChangeObject co2 = new ChangeObject("two");
		
		co1.start();
		Thread.sleep(1000);
		co2.start();
		
		//中断线程，不会抛出异常
		co1.interrupt();
		LockSupport.unpark(co2);
//		LockSupport.unpark(co1);
		
		co1.join();
		co2.join();
	}
}
