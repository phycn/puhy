package cn.puhy.highConcurrency.akka.lifecycle;

import akka.actor.UntypedActor;

public class MyWorker extends UntypedActor {

	public void preStart() {
		System.out.println("MyWorker is starting");
	}
	
	public void postStop() {
		System.out.println("MyWorker is stopping");
	}
	
	@Override
	public void onReceive(Object obj) {
		if(obj == Msg.WORKING) {
			System.out.println("I am working");
		}
		else if(obj == Msg.DONE) {
			System.out.println("Stop working");
		}
		else if(obj == Msg.CLOSE) {
			System.out.println("I will shutdown");
			getSender().tell(Msg.CLOSE, getSelf());
			getContext().stop(getSelf());
		}
		else {
			unhandled(obj);
		}
	}
}
