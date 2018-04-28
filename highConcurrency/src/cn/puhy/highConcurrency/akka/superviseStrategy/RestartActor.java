package cn.puhy.highConcurrency.akka.superviseStrategy;

import akka.actor.UntypedActor;
import scala.Option;

public class RestartActor extends UntypedActor {

	//新的Actor实例创建后调用，新的取代旧的
	@Override
	public void postRestart(Throwable reason) throws Exception {
		super.postRestart(reason);
		System.out.println("postRestart hashcode:" + this.hashCode());
	}

	//Actor停止时调用
	@Override
	public void postStop() throws Exception {
		System.out.println("postStop hashcode:" + this.hashCode());
	}

	//Actor重启时调用，接着会创建新的Actor
	@Override
	public void preRestart(Throwable reason, Option<Object> message) throws Exception {
		System.out.println("preRestart hashcode:" + this.hashCode());
	}

	@Override
	public void preStart() throws Exception {
		System.out.println("preStart hashcode:" + this.hashCode());
	}

	@Override
	public void onReceive(Object obj) throws Exception {
		if(obj == Msg.DONE) {
			getContext().stop(getSelf());
		}
		else if(obj == Msg.RESTART) {
			System.out.println(((Object)null).toString());
			double a = 0/0;
		}
		else {
			unhandled(obj);
		}
	}
}
