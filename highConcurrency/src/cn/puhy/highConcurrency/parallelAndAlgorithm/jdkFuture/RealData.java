package cn.puhy.highConcurrency.parallelAndAlgorithm.jdkFuture;

import java.util.concurrent.Callable;

public class RealData implements Callable<String> {

	private String str;
	public RealData(String str) {
		this.str = str;
	}
	
	@Override
	public String call() throws Exception {
		
		str += " haha";
		Thread.sleep(1000);
		return str;
	}
}
