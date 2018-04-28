package cn.puhy.highConcurrency.akka.pso;

/**
 * 全局最优
 * @author puhongyu
 *
 */
public final class GBestMsg {
	
	private final PsoValue value;
	
	public PsoValue getValue() {
		return value;
	}

	public GBestMsg(PsoValue value) {
		this.value = value;
	}
}
