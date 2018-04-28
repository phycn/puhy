package cn.puhy.highConcurrency.lock;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 线程内的局部变量
 * @author puhongyu
 *
 */
public class ThreadLocalDemo {
	
	//SimpleDateFormat线程不安全
	private static ThreadLocal<SimpleDateFormat> tl = new ThreadLocal<>();
	
	private static class ParseDate implements Runnable {

		@Override
		public void run() {
			if(tl.get() == null) {
				tl.set(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
			}
			String date = tl.get().format(new Date());
			System.out.println(date);
		}
	}
	
	public static void main(String[] args) throws InterruptedException {
		
		ExecutorService es = Executors.newFixedThreadPool(10);
		for(int i = 0; i < 10; i++) {
			es.execute(new ParseDate());
			Thread.sleep(1000);
		}
	}
}
