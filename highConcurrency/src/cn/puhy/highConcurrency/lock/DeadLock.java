package cn.puhy.highConcurrency.lock;

public class DeadLock extends Thread {
	
	private Object a = new Object();
	private Object b = new Object();
	
	private int temp;
	public DeadLock(int temp) {
		this.temp = temp;
	}
	
	public void run() {
		if(temp == 1) {
			synchronized (a) {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				synchronized (b) {
					System.out.println("占用b");
				}
			}
		}
		else if(temp == 2) {
			synchronized (b) {
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				synchronized (a) {
					System.out.println("占用a");
				}
			}
		}
	}
	
	public static void main(String[] args) throws InterruptedException {
		DeadLock d1 = new DeadLock(1);
		DeadLock d2 = new DeadLock(2);
		d1.start();
		d2.start();
		Thread.sleep(120000);
	}
}
