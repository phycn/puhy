package cn.puhy.highConcurrency.akka.messageRoute;

import java.util.concurrent.atomic.AtomicBoolean;

import com.typesafe.config.ConfigFactory;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import cn.puhy.highConcurrency.akka.inbox.Msg;

public class Main {

	public static AtomicBoolean flag = new AtomicBoolean(true);

	public static void main(String[] args) throws InterruptedException {
		ActorSystem system = ActorSystem.create("router", ConfigFactory.load(""));
		ActorRef worker = system.actorOf(Props.create(RouteActor.class), "routeActor");
		
		int i = 1;
		while(flag.get()) {
			worker.tell(Msg.WORKING, ActorRef.noSender());
			if(i % 10 == 0) {
				worker.tell(Msg.CLOSE, ActorRef.noSender());
			}
			i++;
			Thread.sleep(1000);;
		}
	}
}
