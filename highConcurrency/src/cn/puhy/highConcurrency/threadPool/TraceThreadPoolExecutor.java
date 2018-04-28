package cn.puhy.highConcurrency.threadPool;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class TraceThreadPoolExecutor extends ThreadPoolExecutor {

	public TraceThreadPoolExecutor(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit,
			BlockingQueue<Runnable> workQueue, ThreadFactory threadFactory) {
		super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue, threadFactory);
	}
	
	public void execute(Runnable task) {
//		super.execute(wrap(task, clientTrace(), Thread.currentThread().getName()));
	}
	
	private Runnable wrap(final Runnable task, final Exception clientStack, String clientThreadName) {
		
		return new Runnable() {

			@Override
			public void run() {
				try {
					task.run();
				}
				catch(Exception e) {
					clientStack.printStackTrace();
					throw e;
				}
			}
		};
	}
}
