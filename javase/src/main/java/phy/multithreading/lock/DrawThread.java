package phy.multithreading.lock;

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
        account.draw(drawAmount);
    }

    public static void main(String[] args) {
        Account acc = new Account("253399933", 1000);
        new DrawThread("乙", acc, 600).start();
        new DrawThread("甲", acc, 401).start();
    }
}
