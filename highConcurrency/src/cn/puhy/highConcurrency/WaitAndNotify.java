package cn.puhy.highConcurrency;

/**
 * wait和notify只能在同步块中使用
 * @author puhongyu
 *
 */
public class WaitAndNotify {

	static Object object = new Object();

	static class T1 extends Thread {
		public void run() {
			synchronized (object) {
				System.out.println(System.currentTimeMillis() + "：T1启动");
				try {
					System.out.println(System.currentTimeMillis() + "：T1等待");
					// wait会释放对象的锁
					object.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println(System.currentTimeMillis() + "：T1结束");
			}
		}
	}

	static class T2 extends Thread {

		public void run() {
			synchronized (object) {
				System.out.println(System.currentTimeMillis() + "：T2启动,通知其他线程");
				// 通知其他等待线程中的随机一个，notifyAll为通知全部
				object.notify();
				System.out.println(System.currentTimeMillis() + "：T2结束");
			}
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		new T1().start();
		new T2().start();
	}
}
