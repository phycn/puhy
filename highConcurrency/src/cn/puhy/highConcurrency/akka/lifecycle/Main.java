package cn.puhy.highConcurrency.akka.lifecycle;

import com.typesafe.config.ConfigFactory;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.PoisonPill;
import akka.actor.Props;

public class Main {
	public static void main(String[] args) {
		
		ActorSystem system = ActorSystem.create("lifecycle", ConfigFactory.load("hello.conf"));
		ActorRef worker = system.actorOf(Props.create(MyWorker.class), "worker");
		system.actorOf(Props.create(WatchActor.class, worker), "watcher");
		worker.tell(Msg.WORKING, ActorRef.noSender());
		worker.tell(Msg.DONE, ActorRef.noSender());
		//PoisonPill 毒药丸
		worker.tell(PoisonPill.getInstance(), ActorRef.noSender());
	}
}
