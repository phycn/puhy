package cn.puhy.highConcurrency.akka.actorFuture;

import com.typesafe.config.ConfigFactory;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.PoisonPill;
import akka.actor.Props;
import scala.concurrent.Await;
import scala.concurrent.Future;
import scala.concurrent.duration.Duration;

import static akka.pattern.Patterns.ask;
import static akka.pattern.Patterns.pipe;

import java.util.concurrent.TimeUnit;

public class Main {
	public static void main(String[] args) throws Exception {
		ActorSystem system = ActorSystem.create("actorFuture", ConfigFactory.load());
		ActorRef worker = system.actorOf(Props.create(Worker.class), "worker");
		ActorRef printer = system.actorOf(Props.create(Printer.class), "printer");
		
		
		Future<Object> f = ask(worker, 5, 2500);
		//等待Future返回
		int result = (int) Await.result(f, Duration.create(6, TimeUnit.SECONDS));
		System.out.println("result:" + result);
		
		f = ask(worker, 8, 2500);
		//直接导向其他Actor,pipe不会阻塞
		pipe(f, system.dispatcher()).to(printer);
		System.out.println("haha");
		worker.tell(PoisonPill.getInstance(), ActorRef.noSender());
	}
}
