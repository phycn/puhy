package phy.multithreading;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class ThirdThread implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
        // TODO 自动生成的方法存根
        int i = 0;
        for (; i < 100; i++) {
            System.out.println(Thread.currentThread().getName() + " " + i);
        }
        return 234;
    }

    public static void main(String[] args) {

        ThirdThread tt = new ThirdThread();
        FutureTask<Integer> task = new FutureTask<>(tt);
        for (int i = 0; i < 100; i++) {
            //System.out.println(Thread.currentThread().getName() + " " + i);
            if (i == 20) {
                new Thread(task, "线程一").start();
                new Thread(task, "线程二").start();
            }
        }
        try {
            System.out.println(task.get());
        } catch (InterruptedException e) {
            // TODO 自动生成的 catch 块
            e.printStackTrace();
        } catch (ExecutionException e) {
            // TODO 自动生成的 catch 块
            e.printStackTrace();
        }
    }
}
