package cn.puhy.highConcurrency.akka.inbox;

import akka.actor.UntypedActor;
import akka.event.Logging;
import akka.event.LoggingAdapter;

public class MyInbox extends UntypedActor {
	
	private final LoggingAdapter log = Logging.getLogger(getContext().system(), this);

	@Override
	public void onReceive(Object obj) throws Exception {
		if(obj == Msg.WORKING) {
			log.info("I am working");
		}
		else if(obj == Msg.CLOSE) {
			log.info("I will shutdown");
			getSender().tell(Msg.CLOSE, getSelf());
			getContext().stop(getSelf());
		}
		else if(obj == Msg.DONE) {
			log.info("Stop working");
		}
		else {
			unhandled(obj);
		}
	}
}
