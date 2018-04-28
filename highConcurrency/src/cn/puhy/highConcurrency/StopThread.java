package cn.puhy.highConcurrency;

import java.util.Random;

/**
 * stop停掉线程，会释放锁
 * @author puhongyu
 */
public class StopThread {
	private static User user = new User();
	
	static class ChangeObject extends Thread {
		
		public void run() {
			while(true) {
				Random r = new Random();
				synchronized (user) {
					long v = r.nextInt(10000);
					user.setId(Long.toString(v));
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					user.setName(Long.toString(v));
				}
			}
		}
	}
	
	static class ReadObject extends Thread {
		
		public void run() {
			while(true) {
				synchronized (user) {
					if(!user.getId().equals(user.getName())) {
						System.out.println(user);
					}
				}
				Thread.yield();
			}
		}
	}
	
	public static void main(String[] args) throws InterruptedException {
		new ReadObject().start();
		while(true) {
			Thread change = new ChangeObject();
			change.start();
			Thread.sleep(150);
			change.stop();
		}
	}
}

class User {
	private String id;
	private String name;
	
	public User() {
		setId("0");
		setName("0");
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + "]";
	}
}