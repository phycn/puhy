package phy.multithreading.synchronizedCode;

public class DrawThread extends Thread {

    private Account account;
    private double drawAmount;

    public DrawThread(String threadName, Account account, double drawAmount) {
        super(threadName);
        this.account = account;
        this.drawAmount = drawAmount;
    }

    @Override
    public void run() {
        //使用account作为同步监视器，任何线程进入下面同步代码块之前必须先获得对
        //account账户的锁定，其他线程无法获得锁，也就无法修改
        synchronized (account) {
            if (account.getBalance() >= drawAmount) {
                System.out.println(getName() + "取钱成功，取钱" + drawAmount);
                account.setBalance(account.getBalance() - drawAmount);
                System.out.println("余额为" + account.getBalance());

            } else {
                System.out.println(getName() + "余额不足");
            }
        }
    }

    public static void main(String[] args) {
        Account acc = new Account("253399933", 1000);
        new DrawThread("乙", acc, 600).start();
        new DrawThread("甲", acc, 401).start();
    }
}
