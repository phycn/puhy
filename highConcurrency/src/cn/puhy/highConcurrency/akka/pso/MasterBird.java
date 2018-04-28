package cn.puhy.highConcurrency.akka.pso;

import akka.actor.ActorSelection;
import akka.actor.UntypedActor;

public class MasterBird extends UntypedActor {
	
	private PsoValue gBest;

	@Override
	public void onReceive(Object msg) throws Exception {
		if(msg instanceof PBestMsg) {
			PsoValue pBest = ((PBestMsg)msg).getValue();
			if(gBest == null || gBest.getValue() < pBest.getValue()) {
				System.out.println(((PBestMsg) msg).getValue());
				//更新全局最优
				gBest = pBest;
				//通知所有粒子全局最优
				ActorSelection selection = getContext().actorSelection("/user/bird_*");
				selection.tell(gBest, getSelf());
			}
			else {
				unhandled(msg);
			}
		}
	}
}
