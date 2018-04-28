package cn.puhy.highConcurrency;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * ArrayList线程不安全
 * @author puhongyu
 *
 */
public class ArrayListMultiThread {
	
//	private static ArrayList<Integer> list = new ArrayList<>();
	//用Collections包装的list是线程安全的，但是效率低下
	private static List<Integer> list = Collections.synchronizedList(new ArrayList<Integer>());
	static class AddThread extends Thread {
		public void run() {
			for(int i = 0; i < 1000000; i++) {
				list.add(i);
			}
		}
	}
	
	public static void main(String[] args) throws InterruptedException {
		AddThread t1 = new AddThread();
		AddThread t2 = new AddThread();
		t1.start();
		t2.start();
		t1.join();
		t2.join();
		System.out.println(list.size());
	}
}
