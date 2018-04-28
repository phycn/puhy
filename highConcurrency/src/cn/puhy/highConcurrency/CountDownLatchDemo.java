package cn.puhy.highConcurrency;

import java.util.concurrent.CountDownLatch;

/**
 * 倒计时器
 * @author puhongyu
 *
 */
public class CountDownLatchDemo implements Runnable {
	
	//计数数量为10，需要10个线程完成任务，等待的线程才能继续执行
	private static CountDownLatch cdl = new CountDownLatch(10);
	@Override
	public void run() {
		try {
			Thread.sleep(1000);
			System.out.println(Thread.currentThread().getName() + " 检查完毕 " + cdl.getCount());
			//一个线程完成计数器减一
			cdl.countDown();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) throws InterruptedException {
		
		CountDownLatchDemo cd = new CountDownLatchDemo();
		for(int i = 0; i < 10; i++) {
			Thread.sleep(1000);
			new Thread(cd).start();
		}
		//等待计数器全部完成
		cdl.await();
		System.out.println("所有检查完毕");
	}
}
