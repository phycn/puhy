package cn.puhy.highConcurrency.threadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 自定义线程池
 * @author puhongyu
 *
 */
public class CustomThreadPool implements Runnable {

	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName() + " 运行");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) throws InterruptedException {
		
		//参数 1.线程数量 2.最大线程数量 3.超过线程数量时，多余的线程存活时间 4.时间单位 5.任务队列，被提交尚未执行的任务 6.拒绝策略
		ExecutorService es = new ThreadPoolExecutor(5, 5, 0L, TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>(10), new MyReject());
		CustomThreadPool c = new CustomThreadPool();
		for(int i = 0; i < 100; i++) {
			es.submit(c);
			Thread.sleep(100);
		}
	}
}

/**
 * 自定义拒绝策略
 * @author puhongyu
 *
 */
class MyReject implements RejectedExecutionHandler {

	@Override
	public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
		System.out.println(r.toString() + " 拒绝");
	}
}
