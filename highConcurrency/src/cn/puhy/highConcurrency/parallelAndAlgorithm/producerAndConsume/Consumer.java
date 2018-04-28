package cn.puhy.highConcurrency.parallelAndAlgorithm.producerAndConsume;

import java.util.concurrent.BlockingQueue;

/**
 * 消费者
 * @author puhongyu
 *
 */
public class Consumer implements Runnable {

	private BlockingQueue<Data> queue;
	private static final int SLEEPTIME = 1000;
	
	public Consumer(BlockingQueue<Data> queue) {
		this.queue = queue;
	}
	
	@Override
	public void run() {
		
		System.out.println("消费者启动：" + Thread.currentThread().getId());
		
		try {
			while(true) {
				//取走队列第一个对象，队列为空阻塞直到有新对象加入
				Data data = queue.take();
				if(data != null) {
					int a = data.getNum() * data.getNum();
					System.out.println("-----计算平方：" + a);
					Thread.sleep(SLEEPTIME);
				}
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
			Thread.currentThread().interrupt();
		}
	}
}
