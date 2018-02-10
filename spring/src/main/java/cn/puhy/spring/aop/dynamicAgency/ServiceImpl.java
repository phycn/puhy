package cn.puhy.spring.aop.dynamicAgency;

import java.util.Random;

public class ServiceImpl implements Service {

	private Random r = new Random();
	
	@Override
	public void service1() {
		long time = r.nextInt(2000);
		System.out.println("执行service1");
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void service2() {
		long time = r.nextInt(2000);
		System.out.println("执行service2");
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
