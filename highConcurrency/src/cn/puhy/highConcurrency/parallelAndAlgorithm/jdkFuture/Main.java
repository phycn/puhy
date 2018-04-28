package cn.puhy.highConcurrency.parallelAndAlgorithm.jdkFuture;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

public class Main {
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		
		FutureTask<String> task = new FutureTask<>(new RealData("phy"));
		ExecutorService es = Executors.newFixedThreadPool(1);
		es.submit(task);
		System.out.println("请求完毕");
		System.out.println(task.get());
	}
}
