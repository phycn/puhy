package cn.puhy.highConcurrency.jdk8;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CompletableFutureDemo1 implements Runnable {
	
	private CompletableFuture<Integer> cf = null;
	
	public CompletableFutureDemo1(CompletableFuture<Integer> cf) {
		this.cf = cf;
	}

	@Override
	public void run() {
		int num = 0;
		try {
			num = cf.get() * cf.get();
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
		
		System.out.println(num);
	}
	
	public static void main(String[] args) throws InterruptedException {
		
		CompletableFuture<Integer> cf = new CompletableFuture<Integer>();
		new Thread(new CompletableFutureDemo1(cf)).start();
		//模拟长时间计算过程
		Thread.sleep(2000);
		cf.complete(30);
	}
}
