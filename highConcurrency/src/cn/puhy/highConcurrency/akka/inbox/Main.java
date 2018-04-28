package cn.puhy.highConcurrency.akka.inbox;

import java.util.concurrent.TimeUnit;

import com.typesafe.config.ConfigFactory;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Inbox;
import akka.actor.Props;
import akka.actor.Terminated;
import scala.concurrent.duration.Duration;

public class Main {
	public static void main(String[] args) {
		
		ActorSystem system = ActorSystem.create("myInbox", ConfigFactory.load());
		ActorRef worker = system.actorOf(Props.create(MyInbox.class), "worker");
		
		Inbox inbox = Inbox.create(system);
		//监视Actor
		inbox.watch(worker);
		//发送消息
		inbox.send(worker, Msg.WORKING);
		inbox.send(worker, Msg.DONE);
		inbox.send(worker, Msg.CLOSE);
		
		while(true) {
			Object msg = inbox.receive(Duration.create(1, TimeUnit.SECONDS));
			if(msg instanceof Terminated) {
				system.shutdown();
				break;
			}
			else {
				System.out.println(msg);
			}
		}
	}
}
