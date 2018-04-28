package cn.puhy.highConcurrency.jdk8;

import java.util.concurrent.locks.StampedLock;

public class StampedLockDemo {
	
	private double x;
	private double y;
	
	private final StampedLock sl = new StampedLock();
	
	private void add() {
		//写锁
		long stamp = sl.writeLock();
		x++;
		y++;
		sl.unlockWrite(stamp);
	}
	
	private double read() {
		//尝试一次乐观锁
		long stamp = sl.tryOptimisticRead();
		double currentX = x;
		double currentY = y;
		//验证戳，验证不通过说明有修改，重新获得悲观锁
		if(!sl.validate(stamp)) {
			stamp = sl.readLock();
			currentX = x;
			currentY = y;
			sl.unlockRead(stamp);
		}
		return currentX * currentY;
	}
}
