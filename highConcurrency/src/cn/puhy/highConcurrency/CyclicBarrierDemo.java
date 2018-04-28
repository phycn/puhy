package cn.puhy.highConcurrency;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierDemo {
	
	private static class Soldier implements Runnable {

		private String name;
		private CyclicBarrier cyclic;
		
		Soldier(String name, CyclicBarrier cyclic) {
			this.name = name;
			this.cyclic = cyclic;
		}
		
		@Override
		public void run() {
			try {
				//等待所有线程
				cyclic.await();
				//业务处理
				doWork();
				//等待所有线程
				cyclic.await();
			} catch (InterruptedException | BrokenBarrierException e) {
				e.printStackTrace();
			}
		}
		
		//模拟业务流程
		void doWork() throws InterruptedException {
			Thread.sleep(1000);
			System.out.println(name + "任务完成");
		}
	}
	
	/**
	 * 计数器完成一次后执行的动作
	 * @author puhongyu
	 *
	 */
	private static class BarrierAction implements Runnable {
		
		private int num;
		private boolean flag = false;
		BarrierAction(int num) {
			this.num = num;
		}

		@Override
		public void run() {
			if(flag) {
				System.out.println(num + "个士兵任务完成");
			}
			else {
				System.out.println(num + "个士兵集合完成");
				flag = true;
			}
		}
	}
	
	public static void main(String[] args) {
		
		int num = 10;
		//10次计数后执行BarrierAction
		CyclicBarrier cb = new CyclicBarrier(num, new BarrierAction(num));
		for(int i = 0; i < num; i++) {
			System.out.println(i + "士兵报道");
			new Thread(new Soldier("士兵" + i, cb)).start();
		}
	}
}
