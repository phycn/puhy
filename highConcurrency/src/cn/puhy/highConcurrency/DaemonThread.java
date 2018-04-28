package cn.puhy.highConcurrency;

public class DaemonThread extends Thread {
	
	public void run() {
		while(true) {
			System.out.println("haha");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) throws InterruptedException {
		DaemonThread dt = new DaemonThread();
		//设置为守护线程必须在start方法前
		dt.setDaemon(true);
		dt.start();
		//随着主线程结束，守护线程也会结束
		Thread.sleep(3000);
	}
}
