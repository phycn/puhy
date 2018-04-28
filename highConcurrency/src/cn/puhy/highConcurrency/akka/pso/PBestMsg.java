package cn.puhy.highConcurrency.akka.pso;

/**
 * 个体最优
 * @author puhongyu
 *
 */
public final class PBestMsg {
	
	private final PsoValue value;
	
	public PsoValue getValue() {
		return value;
	}

	public PBestMsg(PsoValue value) {
		this.value = value;
	}
}
