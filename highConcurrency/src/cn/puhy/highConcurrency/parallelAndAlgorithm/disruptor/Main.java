package cn.puhy.highConcurrency.parallelAndAlgorithm.disruptor;

import java.nio.ByteBuffer;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import com.lmax.disruptor.BlockingWaitStrategy;
import com.lmax.disruptor.RingBuffer;
import com.lmax.disruptor.dsl.Disruptor;
import com.lmax.disruptor.dsl.ProducerType;

public class Main {
	public static void main(String[] args) throws InterruptedException {
		
		//消费者线程池
		Executor es = Executors.newCachedThreadPool();
		DataFactory df = new DataFactory();
		//缓冲区大小，必须为2的N次方
		int bufferSize = 32;
		//BlockingWaitStrategy为等待策略，还有SleepingWaitStrategy，YieldingWaitStrategy
		Disruptor<Data> disruptor = new Disruptor<Data>(df, bufferSize, es, ProducerType.MULTI, new BlockingWaitStrategy());
		
		Consumer[] arr = {new Consumer(), new Consumer(), new Consumer()};
		disruptor.handleEventsWithWorkerPool(arr);
		disruptor.start();
		
		RingBuffer<Data> ringBuffer = disruptor.getRingBuffer();
		Producer producer = new Producer(ringBuffer);
		ByteBuffer bb = ByteBuffer.allocateDirect(8);
		
		for(long i = 0; i < 100; i++) {
			bb.putLong(0, i);
			producer.pushData(bb);
			Thread.sleep(1000);
			System.out.println("");
		}
	}
}
