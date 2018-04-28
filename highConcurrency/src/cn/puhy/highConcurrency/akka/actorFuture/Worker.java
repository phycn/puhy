package cn.puhy.highConcurrency.akka.actorFuture;

import akka.actor.UntypedActor;
import cn.puhy.highConcurrency.akka.common.Msg;

public class Worker extends UntypedActor {

	@Override
	public void onReceive(Object obj) throws Exception {
		if(obj instanceof Integer) {
			int i = (Integer)obj;
			Thread.sleep(2000);
			getSender().tell(i * i, getSelf());
		}
		if(obj == Msg.DONE) {
			System.out.println("Stop working");
		}
		if(obj == Msg.CLOSE) {
			System.out.println("I will shutdown");
			getSender().tell(Msg.CLOSE, getSelf());
			getContext().stop(getSelf());
		}
	}
}
