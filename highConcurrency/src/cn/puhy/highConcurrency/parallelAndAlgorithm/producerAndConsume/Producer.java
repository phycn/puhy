package cn.puhy.highConcurrency.parallelAndAlgorithm.producerAndConsume;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 生产者
 * 
 * @author puhongyu
 *
 */
public class Producer implements Runnable {

	private volatile boolean isRunning = true;
	private BlockingQueue<Data> queue;
	private static AtomicInteger count = new AtomicInteger();
	private static final int SLEEPTIME = 1000;

	public Producer(BlockingQueue<Data> queue) {
		this.queue = queue;
	}

	@Override
	public void run() {

		Data data = null;
		System.out.println("生产者启动：" + Thread.currentThread().getId());

		try {
			while (isRunning) {
				Thread.sleep(SLEEPTIME);
				//构造任务数据
				data = new Data(count.incrementAndGet());
				System.out.println("放入队列：" + data.getNum());
				//在指定的时间后，还不能加入队列返回false
				if(!queue.offer(data, 2, TimeUnit.SECONDS)) {
					System.out.println("放入队列失败：" + data.getNum());
				}
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
			Thread.currentThread().interrupt();
		}

	}
	
	public void stop() {
		isRunning = false;
	}
}
