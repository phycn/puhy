package cn.puhy.highConcurrency;

import java.util.concurrent.Semaphore;

public class SemaphoreDemo implements Runnable {
	
	//信号量对象，指定许可数量
	private final Semaphore semp = new Semaphore(5);

	@Override
	public void run() {
		
		try {
			//尝试获得许可
			semp.acquire();
			Thread.sleep(2000);
			System.out.println(Thread.currentThread().getName() + " 正在工作");
			//释放许可
			semp.release();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		SemaphoreDemo sd = new SemaphoreDemo();
		for(int i = 0; i < 20; i++) {
			new Thread(sd).start();
		}
	}
}
