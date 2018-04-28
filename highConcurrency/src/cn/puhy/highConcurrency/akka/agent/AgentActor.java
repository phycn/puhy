package cn.puhy.highConcurrency.akka.agent;

import akka.actor.UntypedActor;
import akka.dispatch.Mapper;
import scala.concurrent.Future;

public class AgentActor extends UntypedActor {

	Mapper<Integer, Integer> addMapper = new Mapper<Integer, Integer>() {

		@Override
		public Integer apply(Integer i) {
			return ++i;
		}
	};
	
	@Override
	public void onReceive(Object obj) throws Exception {
		if(obj instanceof Integer) {
			for(int i = 0; i < 10000; i++) {
				Future<Integer> f = AgentMain.countAgent.alter(addMapper);
				AgentMain.futures.add(f);
			}
			System.out.println(AgentMain.futures.size());
			getContext().stop(getSelf());
		}
		else {
			unhandled(obj);
		}
	}
}
