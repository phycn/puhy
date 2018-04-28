package cn.puhy.highConcurrency.threadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class FixedThreadPool implements Runnable {

    @Override
    public void run() {
        System.out.println(System.currentTimeMillis() + "  " + Thread.currentThread().getId());
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        //创建5个线程的线程池
        ExecutorService es = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 10; i++) {
            Thread t = new Thread(new FixedThreadPool());
            //实际执行的是ThreadPoolExecutor.execute方法
            es.submit(t);
        }
        new Thread(new MonitorThreadPoolUtil((ThreadPoolExecutor) es, 1)).start();
        //关闭线程池
        es.shutdown();
    }
}
