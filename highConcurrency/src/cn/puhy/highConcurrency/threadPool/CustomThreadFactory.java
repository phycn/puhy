package cn.puhy.highConcurrency.threadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 自定义线程创建
 * @author puhongyu
 *
 */
public class CustomThreadFactory {
	
	private static class MyTask implements Runnable {

		@Override
		public void run() {
			
			System.out.println(Thread.currentThread().isDaemon());
//			try {
//				Thread.sleep(1000);
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
		}
	}
	
	public static void main(String[] args) throws InterruptedException {
		
		//SynchronousQueue为直接提交队列
		ExecutorService es = new ThreadPoolExecutor(5, 5, 0L, TimeUnit.SECONDS, new SynchronousQueue<Runnable>(), new ThreadFactory() {

			@Override
			public Thread newThread(Runnable r) {
				Thread t = new Thread(r);
				t.setDaemon(true);
				System.out.println("创建" + t);
				return t;
			}
		});
		
		MyTask task = new MyTask();
		for(int i = 0; i < 10; i++) {
			Thread.sleep(1000);
			es.submit(task);
		}
	}
}
