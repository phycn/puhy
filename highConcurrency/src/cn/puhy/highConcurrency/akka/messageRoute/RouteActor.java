package cn.puhy.highConcurrency.akka.messageRoute;

import java.util.ArrayList;
import java.util.List;

import akka.actor.ActorRef;
import akka.actor.Props;
import akka.actor.Terminated;
import akka.actor.UntypedActor;
import akka.event.Logging;
import akka.event.LoggingAdapter;
import akka.routing.ActorRefRoutee;
import akka.routing.BroadcastRoutingLogic;
import akka.routing.RandomRoutingLogic;
import akka.routing.RoundRobinRoutingLogic;
import akka.routing.Routee;
import akka.routing.Router;
import cn.puhy.highConcurrency.akka.inbox.Msg;
import cn.puhy.highConcurrency.akka.inbox.MyInbox;

public class RouteActor extends UntypedActor {

	private final LoggingAdapter log = Logging.getLogger(getContext().system(), this);
	
	private int count = 0;
	
	public Router router;
	{
		List<Routee> routees = new ArrayList<Routee>();
		for(int i = 0; i < 5; i++) {
			ActorRef worker = getContext().actorOf(Props.create(MyInbox.class), "worker_" + i);
			//监听
			getContext().watch(worker);
			routees.add(new ActorRefRoutee(worker));
		}
		
		//RoundRobinRoutingLogic对所有的Routee进行轮询消息发送
		//BroadcastRoutingLogic广播策略，每个都发
		//RandomRoutingLogic随机投递策略
		//SmallestMailboxRoutingLogic空闲Actor优先
		router = new Router(new RandomRoutingLogic(), routees);
	}
	
	@Override
	public void onReceive(Object obj) throws Exception {
		if(obj instanceof Msg) {
			//路由转发
			router.route(obj, getSender());
		}
		else if(obj instanceof Terminated) {
			router.removeRoutee(((Terminated)obj).actor());
			count++;
			log.info(((Terminated)obj).actor().path() + " is closed, routees=" + (5 - count));
			if(count == 5) {
				System.out.println("close system");
				Main.flag.set(false);
				getContext().system().shutdown();
			}
		}
		else {
			unhandled(obj);
		}
	}
}
