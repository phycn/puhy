package cn.puhy.highConcurrency.akka.pso;

import java.util.List;

/**
 * PsoValue中x和value的关系
 * @author puhongyu
 *
 */
public class Fitness {
	public static double fitness(List<Double> x) {
		//sum为总收益
		double sum = 0;
		for(int i = 0, length = x.size(); i < length; i++) {
			sum += Math.sqrt(x.get(i));
		}
		return sum;
	}
}
