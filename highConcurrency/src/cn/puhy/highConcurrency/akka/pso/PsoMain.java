package cn.puhy.highConcurrency.akka.pso;

import akka.actor.ActorSystem;
import akka.actor.Props;

public class PsoMain {
	
	//粒子总数
	private final static int BIRD_NUM = 1000000;
	public static void main(String[] args) {
		ActorSystem system = ActorSystem.create("psoSystem");
		system.actorOf(Props.create(MasterBird.class), "masterbird");
		for(int i = 0; i < BIRD_NUM; i++) {
//			System.out.println(i);
			system.actorOf(Props.create(Bird.class), "bird_" + i);
		}
		
		system.shutdown();
	}
}
