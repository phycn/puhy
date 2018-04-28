package cn.puhy.highConcurrency.jdk8;

import java.util.concurrent.atomic.LongAdder;

public class LongAdderDemo implements Runnable {

	private static LongAdder l = new LongAdder();
	
	@Override
	public void run() {
		long v = l.sum();
		while(v < 100000) {
			l.increment();
			v = l.sum();
		}
		System.out.println(v);
	}
	
	public static void main(String[] args) {
		
		LongAdderDemo d = new LongAdderDemo();
		for(int i = 0; i < 10; i++) {
			new Thread(d).start();
		}
	}
}
