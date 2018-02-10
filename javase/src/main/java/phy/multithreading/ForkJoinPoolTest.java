package phy.multithreading;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;
import java.util.concurrent.TimeUnit;

public class ForkJoinPoolTest {

    public static void main(String ... args) throws InterruptedException {
        
        ForkJoinPool pool = new ForkJoinPool();
        //提交可分解的任务
        pool.submit(new PrintTask(0,51));
        pool.awaitTermination(2, TimeUnit.SECONDS);
        pool.shutdown();
    }
}

//RecursiveAction代表没有返回值的任务
class PrintTask extends RecursiveAction {

    //每个小任务最多打印50个数
    private static final int THRESHOLD = 50;
    private int start;
    private int end;

    public PrintTask(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    protected void compute() {

        if (end - start < THRESHOLD) {
            for (int i = start; i <= end; i++) {
                System.out.println(Thread.currentThread().getName() + "----" + i);
            }
        }
        else {
            int mid = (end + start)/2;
            PrintTask left = new PrintTask(start, mid);
            PrintTask right = new PrintTask(mid, end);
            //并行执行两个小任务
            left.fork();
            right.fork();
        }
    }
}
