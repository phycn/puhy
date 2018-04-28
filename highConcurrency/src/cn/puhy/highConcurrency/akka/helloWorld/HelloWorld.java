package cn.puhy.highConcurrency.akka.helloWorld;

import akka.actor.ActorRef;
import akka.actor.Props;
import akka.actor.UntypedActor;

public class HelloWorld extends UntypedActor {
	
	private ActorRef greeter;

	@Override
	public void onReceive(Object msg) {
		if(msg == Greeter.Msg.DONE) {
			greeter.tell(Greeter.Msg.GREET, getSelf());
			getContext().stop(getSelf());
		}
		else {
			unhandled(msg);
		}
	}
	
	//初始化工作
	public void preStart() {
		//actorOf建立Actor
		greeter = getContext().actorOf(Props.create(Greeter.class), "greeter");
		System.out.println("greeter path:" + greeter.path());
		greeter.tell(Greeter.Msg.GREET, getSelf());
	}
}
