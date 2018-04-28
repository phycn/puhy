package cn.puhy.highConcurrency.akka.switchStatus;

import akka.actor.UntypedActor;
import akka.event.Logging;
import akka.event.LoggingAdapter;
import akka.japi.Procedure;

public class SwitchActor extends UntypedActor {

	private final LoggingAdapter log = Logging.getLogger(getContext().system(), this);
	
	public static enum Msg {
		SLEEP, PLAY, CLOSE
	}
	
	Procedure<Object> angry = new Procedure<Object>() {

		@Override
		public void apply(Object obj) throws Exception {
			System.out.println("angryApply:" + obj);
			if(obj == Msg.SLEEP) {
				getSender().tell("I am already angry", getSelf());
			}
			else if(obj == Msg.PLAY) {
				System.out.println("I like playing");
				getContext().become(happy);
			}
		}
	};
	
	Procedure<Object> happy = new Procedure<Object>() {

		@Override
		public void apply(Object obj) throws Exception {
			System.out.println("happyApply:" + obj);
			if(obj == Msg.SLEEP) {
				System.out.println("I am already angry");
				getContext().become(angry);
			}
			else if(obj == Msg.PLAY) {
				getSender().tell("I like playing", getSelf());
			}
		}
	};
	
	@Override
	public void onReceive(Object obj) throws Exception {
		System.out.println("onReceive:" + obj);
		if(obj == Msg.SLEEP) {
			getContext().become(angry);
		}
		else if(obj == Msg.PLAY) {
			getContext().become(happy);
		}
		else {
			unhandled(obj);
		}
	}
}
