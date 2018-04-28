package cn.puhy.highConcurrency.akka.lifecycle;

import akka.actor.ActorRef;
import akka.actor.Terminated;
import akka.actor.UntypedActor;
import akka.event.Logging;
import akka.event.LoggingAdapter;

/**
 * 监视Actor,监视MyWorker
 * @author puhongyu
 *
 */
public class WatchActor extends UntypedActor {
	
	private final LoggingAdapter log = Logging.getLogger(getContext().system(), this);
	
	public WatchActor(ActorRef ref) {
		getContext().watch(ref);
	}
	
	@Override
	public void onReceive(Object obj) {
		if(obj instanceof Terminated) {
			System.out.println(((Terminated)obj).getActor().path() + " has terminated");
			//关闭系统
			getContext().system().shutdown();
		}
		else {
			unhandled(obj);
		}
	}
}
