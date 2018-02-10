package phy.multithreading.communication.condition;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Account {
    
    //定义Lock对象
    private final Lock lock = new ReentrantLock();
    //获得Lock对象的Condition，进行线程通信
    private final Condition cond = lock.newCondition();
    
    private String accountNo;
    private double balance;
    
    //标识账户中是否已有存款
    private boolean flag = false;
    
    public Account(String accountNo, double balance) {
        
        this.accountNo = accountNo;
        this.balance = balance;
    }

    /**
     * @return the account
     */
    public String getAccountNo() {
        return accountNo;
    }

    /**
     * @param account the account to set
     */
    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    /**
     * @return the balance
     */
    public double getBalance() {
        return balance;
    }
    
    //取钱
    public void draw(double drawAmount) throws Exception {
        
        lock.lock();
        //如果flag为假，表明账户中还没有人存钱进去，取钱方法阻塞
        if(!flag) {
            cond.await();
        }
        else {
            System.out.println(Thread.currentThread().getName() + "取钱" + drawAmount);
            balance -= drawAmount;
            System.out.println("账户余额：" + balance);
            //
            flag = false;
            //唤醒其他线程
            cond.signalAll();
        }
        //释放锁
        lock.unlock();
    }
    
    //存钱
    public void deposit(double depositAmount) throws Exception {
        
        //为真表示已存钱，存钱方法阻塞
        if(flag) {
           cond.await();
        }
        else {
            System.out.println(Thread.currentThread().getName() + "存钱" + depositAmount);
            balance += depositAmount;
            System.out.println("账户余额：" + balance);
            flag = true;
            cond.signalAll();
        }
        lock.unlock();
    }
}
