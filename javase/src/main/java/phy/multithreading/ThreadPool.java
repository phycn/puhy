package phy.multithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPool implements Runnable {

	@Override
	public void run() {
		for(int i = 0; i < 100; i++) {
			System.out.println(Thread.currentThread().getName() + " " + i);
		}
	}
	public static void main(String[] args) {
		
		ExecutorService pool = Executors.newFixedThreadPool(5);
		pool.submit(new ThreadPool());
		pool.submit(new ThreadPool());
		pool.shutdown();
	}
}
