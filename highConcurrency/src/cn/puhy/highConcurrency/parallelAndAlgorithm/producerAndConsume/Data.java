package cn.puhy.highConcurrency.parallelAndAlgorithm.producerAndConsume;

/**
 * 共享数据类型
 * @author puhongyu
 *
 */
public final class Data {
	
	private final int num;
	public int getNum() {
		return num;
	}
	
	public Data(int num) {
		this.num = num;
	}
}
