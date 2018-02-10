/* 
    多个线程共享类的实例属性
*/
package phy.multithreading;

public class RunnableTest implements Runnable {

    private int i = 1;

    @Override
    public void run() {

        for (; i < 100; i++) {
            System.out.println(Thread.currentThread().getName() + " " + i);
        }
    }

    public static void main(String[] args) {

        for (int i = 0; i < 100; i++) {
            //System.out.println(Thread.currentThread().getName() + " " + i);
            if (i == 20) {
                RunnableTest st = new RunnableTest();
                new Thread(st, "线程1").start();
                new Thread(st, "线程2").start();
            }
        }
    }
}
