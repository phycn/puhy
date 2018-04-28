package cn.puhy.highConcurrency.akka.helloWorld;

import akka.actor.UntypedActor;

public class Greeter extends UntypedActor {
	
	public static enum Msg {
		GREET, DONE;
	}

	//接收消息
	@Override
	public void onReceive(Object obj) {
		if(obj == Msg.GREET) {
			System.out.println("1 hello world");
			getSender().tell(Msg.DONE, getSelf());
		}
		else {
			unhandled(obj);
		}
	}
}
