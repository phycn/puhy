package phy.multithreading;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;
import java.util.concurrent.RecursiveTask;

public class RecursiveTaskTest {
    
    public static void main(String ... args) throws InterruptedException, ExecutionException {
        

        ForkJoinPool f = new ForkJoinPool();
        Future<Integer> fu = f.submit(new Sum(0, 10000));
        System.out.println(fu.get());
        f.shutdown();
    }
}

class Sum extends RecursiveTask<Integer> {
    
    //定义每个小任务最大累加数
    private static final int THRESHOLD = 100;
    private int start;
    private int end;
    
    public Sum(int start, int end) {
        this.start = start;
        this.end = end;
    }
    
    @Override
    protected Integer compute() {
        
        int sum = 0;
        
        if(end - start < THRESHOLD) {
           for(int i = start; i <= end; i++) {
               sum += i;
           }
           return sum;
        }
        else {
            //将大任务分解为两个小任务
            int mid = (end + start)/2;
            Sum left = new Sum(start, mid);
            Sum right = new Sum(mid + 1, end);
            //并行执行两个小任务
            left.fork();
            right.fork();
            
            //把两个小任务的结果合并起来
            return left.join() + right.join();
        }
    }    
}
