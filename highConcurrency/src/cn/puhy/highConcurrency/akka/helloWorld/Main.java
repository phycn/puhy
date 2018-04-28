package cn.puhy.highConcurrency.akka.helloWorld;

import com.typesafe.config.ConfigFactory;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;

public class Main {
	public static void main(String[] args) {
		//ActorSystem为管理和维护Actor的系统，一般只需要一个
		ActorSystem system = ActorSystem.create("Hello", ConfigFactory.load("hello.conf"));
		//创建顶级的Actor
		ActorRef ar = system.actorOf(Props.create(HelloWorld.class), "helloworld");
		System.out.println("helloworld path:" + ar.path());
	}
}
