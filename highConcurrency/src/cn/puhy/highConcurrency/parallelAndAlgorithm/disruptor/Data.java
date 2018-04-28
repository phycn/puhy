package cn.puhy.highConcurrency.parallelAndAlgorithm.disruptor;

public class Data {
	
	private long value;
	
	public void setValue(long value) {
		this.value = value;
	}
	
	public long getValue() {
		return value;
	}
}
