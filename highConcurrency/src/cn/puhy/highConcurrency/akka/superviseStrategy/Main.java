package cn.puhy.highConcurrency.akka.superviseStrategy;

import com.typesafe.config.ConfigFactory;

import akka.actor.ActorRef;
import akka.actor.ActorSelection;
import akka.actor.ActorSystem;
import akka.actor.Props;

public class Main {
	public static void main(String[] args) {
		
		ActorSystem system = ActorSystem.create("superviseStrategy", ConfigFactory.load("superviseStrategy.conf"));
		ActorRef ar = system.actorOf(Props.create(Supervisor.class), "Supervisor");
		ar.tell(Props.create(RestartActor.class), ActorRef.noSender());
		//ActorSelection批量发送消息
		ActorSelection as = system.actorSelection("akka://superviseStrategy/user/Supervisor/restartActor");
		
		for(int i = 0; i < 5; i++) {
			as.tell(Msg.RESTART, ActorRef.noSender());
		}
	}
}
