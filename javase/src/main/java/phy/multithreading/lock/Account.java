package phy.multithreading.lock;

import java.util.concurrent.locks.ReentrantLock;

public class Account {

    //定义锁对象

    private final ReentrantLock lock = new ReentrantLock();
    private String accountNo;
    private double balance;

    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    public double getBalance() {
        return balance;
    }

//	public void setBalance(double balance) {
//		this.balance = balance;
//	}
    public Account() {

    }

    public Account(String accountNo, double balance) {
        this.accountNo = accountNo;
        this.balance = balance;
    }

    //同步锁

    public void draw(double drawAmount) {
        //加锁
        lock.lock();
        try {
            if (balance >= drawAmount) {
                System.out.println(Thread.currentThread().getName() + "取钱成功，取钱" + drawAmount);
                balance -= drawAmount;
                System.out.println("余额为" + balance);
            } else {
                System.out.println(Thread.currentThread().getName() + "取钱失败，余额不足");
            }
        } finally {
            //释放锁
            lock.unlock();
        }
    }

    @Override
    public int hashCode() {
        return accountNo.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && obj.getClass() == Account.class) {
            Account target = (Account) obj;
            return target.getAccountNo().equals(accountNo);
        }
        return false;
    }

}
