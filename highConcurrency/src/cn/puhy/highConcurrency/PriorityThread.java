package cn.puhy.highConcurrency;

public class PriorityThread implements Runnable {

	@Override
	public void run() {
		try {
			for(int i = 0; i < 10000; i++) {
				System.out.println(Thread.currentThread().getName() + "  " + i);
//				Thread.sleep(1000);
				Thread.yield();
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		PriorityThread pt1 = new PriorityThread();
		PriorityThread pt2 = new PriorityThread();
		Thread t1 = new Thread(pt1);
		Thread t2 = new Thread(pt2);
		t1.setName("--高优先级");
		t2.setName("低优先级");
		//设置线程优先级，1-10
		t1.setPriority(10);
		t2.setPriority(1);
		t1.start();
		t2.start();
	}
}
