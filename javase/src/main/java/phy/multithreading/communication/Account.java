package phy.multithreading.communication;

public class Account {
    
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
    public synchronized void draw(double drawAmount) throws Exception {
        
        //如果flag为假，表明账户中还没有人存钱进去，取钱方法阻塞
        if(!flag) {
            wait();
        }
        else {
            System.out.println(Thread.currentThread().getName() + "取钱" + drawAmount);
            balance -= drawAmount;
            System.out.println("账户余额：" + balance);
            //
            flag = false;
            //唤醒其他线程
            notifyAll();
        }
    }
    
    //存钱
    public synchronized void deposit(double depositAmount) throws Exception {
        
        //为真表示已存钱，存钱方法阻塞
        if(flag) {
            wait();
        }
        else {
            System.out.println(Thread.currentThread().getName() + "存钱" + depositAmount);
            balance += depositAmount;
            System.out.println("账户余额：" + balance);
            flag = true;
            notifyAll();
        }
    }
}
