package cn.puhy.highConcurrency;

/**
 * interrupt中断线程
 * @author puhongyu
 */
public class InterruptThread {
	public static void main(String[] args) throws InterruptedException {
		Thread t = new Thread() {
			public void run() {
				while(true) {
					//检查中断标志位
					if(Thread.currentThread().isInterrupted()) {
						System.out.println("线程中断！");
						break;
					}
				}
			}
		};
		
		t.start();
		Thread.sleep(1000);
		//通知线程中断，并不会立即中断
		t.interrupt();
	}
}
