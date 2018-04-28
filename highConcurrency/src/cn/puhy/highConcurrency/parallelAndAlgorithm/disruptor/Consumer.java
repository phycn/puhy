package cn.puhy.highConcurrency.parallelAndAlgorithm.disruptor;

import com.lmax.disruptor.WorkHandler;

/**
 * 消费者
 * @author puhongyu
 *
 */
public class Consumer implements WorkHandler<Data> {

	@Override
	public void onEvent(Data data) throws Exception {
		long num = data.getValue() * data.getValue();
		System.out.println(Thread.currentThread().getName() + " " + num);
	}
}
