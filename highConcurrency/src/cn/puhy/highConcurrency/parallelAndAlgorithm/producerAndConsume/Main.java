package cn.puhy.highConcurrency.parallelAndAlgorithm.producerAndConsume;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;

public class Main {
	public static void main(String[] args) throws InterruptedException {
		
		BlockingQueue<Data> queue = new LinkedBlockingQueue<>(10);
		Consumer c1 = new Consumer(queue);
		
		ExecutorService es = Executors.newCachedThreadPool();
		
		for(int i = 0; i < 5; i++) {
			Producer p = new Producer(queue);
			es.execute(p);
		}
		
		es.execute(c1);
	}
}
