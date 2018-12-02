package phy;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * @author PUHY
 * 2018-12-02 21:36
 */
public class CompletableFutureDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        runAsyncDemo();
    }

    /**
     * 异步执行
     * @throws ExecutionException
     * @throws InterruptedException
     */
    private static void runAsyncDemo() throws ExecutionException, InterruptedException {
        CompletableFuture completableFuture = CompletableFuture.runAsync(() -> {
            try {
                Thread.sleep(2000);
                System.out.println("完成了！！！");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        System.out.println("我先执行呢");
        completableFuture.get();
    }
}
