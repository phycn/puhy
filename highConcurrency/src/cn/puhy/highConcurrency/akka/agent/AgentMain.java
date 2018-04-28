package cn.puhy.highConcurrency.akka.agent;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.TimeUnit;

import com.typesafe.config.ConfigFactory;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Inbox;
import akka.actor.Props;
import akka.actor.Terminated;
import akka.agent.Agent;
import akka.dispatch.ExecutionContexts;
import akka.dispatch.Futures;
import akka.dispatch.OnComplete;
import scala.concurrent.Future;
import scala.concurrent.duration.Duration;

public class AgentMain {
	
	public static Agent<Integer> countAgent = Agent.create(0, ExecutionContexts.global());
	public static ConcurrentLinkedQueue<Future<Integer>> futures = new ConcurrentLinkedQueue<>();
	
	public static void main(String[] args) {
		ActorSystem system = ActorSystem.create("agent", ConfigFactory.load());
		ActorRef[] counter = new ActorRef[10];
		Inbox inbox = Inbox.create(system);
		for(int i = 0; i < 10; i++) {
			counter[i] = system.actorOf(Props.create(AgentActor.class), "counter_" + i);
			inbox.watch(counter[i]);
			inbox.send(counter[i], 1);
		}
		
		int closeCount = 0;
		//等待所有Actor全部结束
		while(true) {
			Object msg = inbox.receive(Duration.create(1, TimeUnit.SECONDS));
			if(msg instanceof Terminated) {
				closeCount++;
				//所有Actor都停止
				if(closeCount == 10) {
					break;
				}
			}
			else {
				System.out.println(msg);
			}
		}
		
		//等待所有的累加线程完成
		Futures.sequence(futures, system.dispatcher()).onComplete(new OnComplete<Iterable<Integer>>() {

			@Override
			public void onComplete(Throwable arg0, Iterable<Integer> arg1) throws Throwable {
				System.out.println("总数：" + countAgent.get());
				system.shutdown();
			}
		}, system.dispatcher());
	}
}
