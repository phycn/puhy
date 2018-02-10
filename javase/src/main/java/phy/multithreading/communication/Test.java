package phy.multithreading.communication;

public class Test {
    
    public static void main(String[] args) {
        
        Account acc = new Account("phy",0);
        new DrawThread("取钱者", acc, 200).start();
        new DepositThread("甲", acc, 200).start();
        //new DepositThread("乙", acc, 200).start();
    }
}
