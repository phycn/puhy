package cn.puhy.highConcurrency;

public class Sync implements Runnable {

	private static int i = 0;
	
	private static synchronized void add() {
		i++;
	}
	
	@Override
	public void run() {
		for(int j = 0; j < 100000; j++) {
			add();
		}
	}
	
	public static void main(String[] args) throws InterruptedException {
		
		//多个对象时，synchronized修饰的不为static，同步会失败，单例模式也可以这样用，多个对象也可以锁类来实现
		Thread t1 = new Thread(new Sync());
		Thread t2 = new Thread(new Sync());
		t1.start();
		t2.start();
		t1.join();
		t2.join();
		System.out.println(i);
	}
}
