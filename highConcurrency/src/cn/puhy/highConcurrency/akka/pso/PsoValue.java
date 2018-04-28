package cn.puhy.highConcurrency.akka.pso;

import java.util.Collections;
import java.util.List;

/**
 * 可行解
 * @author puhongyu
 *
 */
public final class PsoValue {
	
	//投资方案总收益
	private final double value;
	//每一年的投资额的集合
	private final List<Double> x;
	
	public PsoValue(double value, List<Double> x) {
		this.value = value;
		//不可变集合
		this.x = Collections.unmodifiableList(x);
	}

	public double getValue() {
		return value;
	}

	public List<Double> getX() {
		return x;
	}
	
	public String toString() {
		
		StringBuffer sb = new StringBuffer();
		sb.append("value: ").append(value).append("\n").append(x.toString());
		return sb.toString();
	}
}
