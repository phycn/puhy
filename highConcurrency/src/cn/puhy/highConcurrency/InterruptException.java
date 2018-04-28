package cn.puhy.highConcurrency;

public class InterruptException {
	public static void main(String[] args) throws InterruptedException {
		Thread t = new Thread() {
			public void run() {
				while (true) {
					// 检查中断标志位
					if (Thread.currentThread().isInterrupted()) {
						System.out.println("线程中断！");
						break;
					}
					try {
						// 休眠过程中被中断会抛出InterruptedException异常
						Thread.sleep(2000);
					} catch (InterruptedException e) {
						e.printStackTrace();
						// 再次中断
						Thread.currentThread().interrupt();
					}
				}
			}
		};

		t.start();
		Thread.sleep(1000);
		// 通知线程中断，并不会立即中断
		t.interrupt();
	}
}
