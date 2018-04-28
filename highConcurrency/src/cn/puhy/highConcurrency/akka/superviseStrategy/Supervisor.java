package cn.puhy.highConcurrency.akka.superviseStrategy;

import java.util.concurrent.TimeUnit;

import akka.actor.OneForOneStrategy;
import akka.actor.Props;
import akka.actor.SupervisorStrategy;
import akka.actor.SupervisorStrategy.Directive;
import akka.actor.UntypedActor;
import akka.japi.Function;
import scala.concurrent.duration.Duration;

public class Supervisor extends UntypedActor {
	
	//1分钟内重复3次
	private static SupervisorStrategy strategy = new OneForOneStrategy(3, Duration.create(1, TimeUnit.MINUTES), 
			new Function<Throwable, Directive>() {

				@Override
				public Directive apply(Throwable t) throws Exception {
					if(t instanceof ArithmeticException) {
						System.out.println("ArithmeticException error");
						//继续，不做任何处理
						return SupervisorStrategy.resume();
					}
					else if(t instanceof NullPointerException) {
						System.out.println("NullPointerException error");
						//重启Actor
						return SupervisorStrategy.restart();
					}
					else if(t instanceof IllegalArgumentException) {
						System.out.println("IllegalArgumentException error");
						//停止Actor
						return SupervisorStrategy.stop();
					}
					else {
						//由更上层的Actor处理
						return SupervisorStrategy.escalate();
					}
				}
	});
	
	//覆盖父类方法，使用自定义的监督策略
	public SupervisorStrategy supervisorStrategy() {
		return strategy;
	}

	@Override
	public void onReceive(Object obj) throws Exception {
		if(obj instanceof Props) {
			getContext().actorOf((Props)obj, "restartActor");
		}
		else {
			unhandled(obj);
		}
	}
}
