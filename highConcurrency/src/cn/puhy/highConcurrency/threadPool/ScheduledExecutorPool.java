package cn.puhy.highConcurrency.threadPool;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class ScheduledExecutorPool implements Runnable {

	@Override
	public void run() {
		try {
			Thread.sleep(1000);
			System.out.println(System.currentTimeMillis());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		
		ScheduledExecutorService ses = Executors.newScheduledThreadPool(5);
		ScheduledExecutorPool sep = new ScheduledExecutorPool();
		//创建并执行一个周期任务，第一个参数为具体任务，第二个参数为初始延迟时间，第三个参数为周期，第四个参数为时间单位
//		ses.scheduleAtFixedRate(sep, 0, 2, TimeUnit.SECONDS);
		
		//与scheduleAtFixedRate不同的是第三个参数，这个是任务完成后延迟指定时间后再执行，而scheduleAtFixedRate是周期性地执行，不会管有没有执行完
		ScheduledFuture<?> future = ses.scheduleWithFixedDelay(sep, 0, 2, TimeUnit.SECONDS);
		//取消该任务，防止再次运行
		future.cancel(false);
	}
}
