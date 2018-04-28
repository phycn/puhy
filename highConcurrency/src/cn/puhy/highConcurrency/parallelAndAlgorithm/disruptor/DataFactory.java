package cn.puhy.highConcurrency.parallelAndAlgorithm.disruptor;

import com.lmax.disruptor.EventFactory;

/**
 * 事件工厂
 * @author puhongyu
 *
 */
public class DataFactory implements EventFactory<Data> {

	@Override
	public Data newInstance() {
		return new Data();
	}
}
