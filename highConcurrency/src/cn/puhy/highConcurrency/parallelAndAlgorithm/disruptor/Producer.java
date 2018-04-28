package cn.puhy.highConcurrency.parallelAndAlgorithm.disruptor;

import java.nio.ByteBuffer;

import com.lmax.disruptor.RingBuffer;

/**
 * 生产者
 * @author puhongyu
 *
 */
public class Producer {
	//RingBuffer为环形队列
	private final RingBuffer<Data> ringBuffer;
	
	public Producer(RingBuffer<Data> ringBuffer) {
		this.ringBuffer = ringBuffer;
	}
	
	public void pushData(ByteBuffer bb) {
		//得到下一个可用的序列号
		long sequence = ringBuffer.next();
		//取得下一个可用的Data
		Data data = ringBuffer.get(sequence);
		data.setValue(bb.getLong(0));
		//发布数据，发布后消费者才能看到
		ringBuffer.publish(sequence);
	}
}
