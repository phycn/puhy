package cn.puhy.highConcurrency;

public class MyThreadGroup implements Runnable{

	@Override
	public void run() {
		String name = Thread.currentThread().getThreadGroup().getName() + "-" + Thread.currentThread().getName();
		while(true) {
			System.out.println(name);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) {
		
		//创建线程组
		ThreadGroup tg = new ThreadGroup("phyTG");
		Thread t1 = new Thread(tg, new MyThreadGroup(), "T1");
		Thread t2 = new Thread(tg, new MyThreadGroup(), "T2");
		t1.start();
		t2.start();
		//活动线程数
		System.out.println(tg.activeCount());
		//打印所有线程
		tg.list();
	}
}
