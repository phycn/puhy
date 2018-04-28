package cn.puhy.highConcurrency.akka.pso;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import akka.actor.ActorSelection;
import akka.actor.UntypedActor;

/**
 * 基本粒子
 * @author puhongyu
 *
 */
public class Bird extends UntypedActor {

	private PsoValue pBest;
	private PsoValue gBest;
	//粒子在各个维度上的速度
	private List<Double> velocity = new ArrayList<>(4);
	private List<Double> x = new ArrayList<>(4);
	private Random random = new Random();

	//接收全局最优，更新速度与位置
	@Override
	public void onReceive(Object msg) throws Exception {
		if(msg instanceof GBestMsg) {
			gBest = ((GBestMsg)msg).getValue();
			//更新速度
			for(int i = 0; i < velocity.size(); i++) {
				updateVelocity(i);
			}
			//更新位置
			for(int i = 0; i < x.size(); i++) {
				updateX(i);
			}
		}
	}
	
	//初始化粒子
	@Override
	public void preStart() throws Exception {
		for(int i = 0; i < 4; i++) {
			//NEGATIVE_INFINITY负无穷大
			velocity.add(Double.NEGATIVE_INFINITY);
			x.add(Double.NEGATIVE_INFINITY);
		}
		
		//x0 <= 400	第一年最多投资400万
		x.set(0, (double) random.nextInt(401));
		
		//第二年 1.1(400-x0) >= x1 -----> 1.1x0 + x1 <= 440
		double x1Max = 440 - 1.1 * x.get(0);
		if(x1Max < 0) {
			x1Max = 0;
		}
		x.set(1, random.nextDouble() * x1Max);
		
		//第三年 1.1[1.1(400-x0) - x1] >= x2
		double x2Max = 484 - 1.21 * x.get(0) - 1.1 * x.get(1);
		if(x2Max < 0) {
			x2Max = 0;
		}
		x.set(2, random.nextDouble() * x2Max);
		
		//第四年 1.1{1.1[1.1(400-x0) - x1]} >= x3
		double x3Max = 532.4 - 1.331 * x.get(0) - 1.21 * x.get(1) - 1.1 * x.get(2);
		if(x3Max < 0) {
			x3Max = 0;
		}
		x.set(3, random.nextDouble() * x3Max);
		
		double newFit = Fitness.fitness(x);
		pBest = new PsoValue(newFit, x);
		
		PBestMsg pBestMsg = new PBestMsg(pBest);
		ActorSelection selection = getContext().actorSelection("/user/masterbird");
		//初始投资方案作为个体最优发送给Master
		selection.tell(pBestMsg, getSelf());
	}
	
	//更新速度
	private double updateVelocity(int i) {
		
		double v = Math.random() * velocity.get(i) + 2 * Math.random() * (pBest.getX().get(i) - x.get(i)) + 2 * Math.random() * (gBest.getX().get(i) - x.get(i));
		v = v > 0 ? Math.min(v, 4) : Math.max(v, -4);
		velocity.set(i, v);
		return v;
	}
	
	//更新位置
	private double updateX(int i) {
		
		double newX = x.get(i) + velocity.get(i);
		x.set(i, newX);
		return newX;
	}
	
	//约束粒子在合理区间内
	private void validateX() {
		if(x.get(0) > 400) {
			x.set(0, (double)random.nextInt(401));
		}
		
		double max = 440 - 1.1 * x.get(0);
		if(x.get(1) > max || x.get(1) < 0) {
			x.set(1, random.nextDouble() * max);
		}
		
		max = 484 - 1.21 * x.get(0) - 1.1 * x.get(1);
		if(x.get(2) > max || x.get(2) < 0) {
			x.set(2, random.nextDouble() * max);
		}
		
		max = 532.4 - 1.331 * x.get(0) - 1.21 * x.get(1) - 1.1 * x.get(2);
		if(x.get(3) > max || x.get(3) < 0) {
			x.set(3, random.nextDouble() * max);
		}
	}
}
