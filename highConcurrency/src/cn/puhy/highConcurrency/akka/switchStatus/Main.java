package cn.puhy.highConcurrency.akka.switchStatus;

import com.typesafe.config.ConfigFactory;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.PoisonPill;
import akka.actor.Props;

public class Main {
	public static void main(String[] args) {
		ActorSystem system = ActorSystem.create("switchActor", ConfigFactory.load());
		ActorRef switchActor = system.actorOf(Props.create(SwitchActor.class), "switchActor");
		switchActor.tell(SwitchActor.Msg.PLAY, ActorRef.noSender());
		switchActor.tell(SwitchActor.Msg.SLEEP, ActorRef.noSender());
		switchActor.tell(SwitchActor.Msg.PLAY, ActorRef.noSender());
		switchActor.tell(SwitchActor.Msg.PLAY, ActorRef.noSender());
		
//		switchActor.tell(PoisonPill.getInstance(), ActorRef.noSender());
		system.shutdown();
	}
}
