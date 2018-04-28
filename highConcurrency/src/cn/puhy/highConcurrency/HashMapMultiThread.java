package cn.puhy.highConcurrency;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * HashMap线程不安全
 * @author puhongyu
 *
 */
public class HashMapMultiThread {
	
	//用Collections包装的map是线程安全的，但是效率低下
	private static Map<Integer, Integer> map = Collections.synchronizedMap(new HashMap<>());
//	private static Map<Integer, Integer> map = new HashMap<>();
	
	static class AddMap extends Thread {
		
		public void run() {
			for(int i = 0; i < 1000000; i++) {
				map.put(i, i);
			}
		}
	}
	
	public static void main(String[] args) throws InterruptedException {
		AddMap t1 = new AddMap();
		AddMap t2 = new AddMap();
		t1.start();
		t2.start();
		t1.join();
		t2.join();
		System.out.println(map.size());
	}
}
