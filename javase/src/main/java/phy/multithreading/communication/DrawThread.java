/*
    取钱线程类
 */
package phy.multithreading.communication;

public class DrawThread extends Thread{
    
    private Account account;
    private double drawAmount;
    
    public DrawThread(String name, Account account, double drawAmount) {
        
        super(name);
        this.account = account;
        this.drawAmount = drawAmount;
    }
    
    //线程执行体
    @Override
    public void run() {
        
        for(int i = 0; i < 10; i++) {
            try {
                account.draw(drawAmount);
            } catch (Exception ex) {
                
                
            }
        }          
    }
}
