package phy.multithreading;

public class JoinThread extends Thread {
    
    @Override
    public void run() {
        
        for(int i = 0; i < 100; i++) {
            
            System.out.println(getName() + " " + i);
        }
    }
    
    public static void main(String[] args) throws InterruptedException {
        
        for(int i = 0; i < 100; i++) {
            
            if(i == 20) {
                JoinThread jt = new JoinThread();
                jt.start();
                //main线程调用了jt线程的join方法，main线程必须等jt执行结束才向下执行
                jt.join();
            }
            System.out.println(Thread.currentThread().getName() + " " + i);
        }
    }
}
