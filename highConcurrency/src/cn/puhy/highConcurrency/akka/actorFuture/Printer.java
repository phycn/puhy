package cn.puhy.highConcurrency.akka.actorFuture;

import akka.actor.UntypedActor;
import cn.puhy.highConcurrency.akka.common.Msg;

public class Printer extends UntypedActor {

	@Override
	public void onReceive(Object obj) throws Exception {
		if(obj instanceof Integer) {
			System.out.println("Printer:" + obj);
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
