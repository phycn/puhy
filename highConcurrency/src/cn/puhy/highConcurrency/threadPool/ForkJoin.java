package cn.puhy.highConcurrency.threadPool;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

/**
 * ForkJoin框架使用
 * @author puhongyu
 *
 */
public class ForkJoin extends RecursiveTask<Long> {

	private static final long THRESHOLD = 50L;
	private long start;
	private long end;
	
	public ForkJoin(long start, long end) {
		this.start = start;
		this.end = end;
	}
	
	@Override
	protected Long compute() {
		
		long sum = 0L;
		boolean flag = (end - start) < THRESHOLD;
		if(flag) {
			for(long i = start; i <= end; i++) {
				sum += i;
			}
		}
		else {
			//分成10个小任务
			long step = (start + end) / 10;
			long pos = start;
			ArrayList<ForkJoin> subTasks = new ArrayList<>();
			
			for(int i = 0; i < 10; i++) {
				long last = pos + step;
				if(last > end) {
					last = end;
				}
				ForkJoin subTask = new ForkJoin(pos, last);
				pos += step + 1;
				
				subTasks.add(subTask);
				subTask.fork();
			}
			
			for(ForkJoin fj : subTasks) {
				sum += fj.join();
			}
		}
		
		return sum;
	}
	
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		
		ForkJoinPool pool = new ForkJoinPool();
		ForkJoin task = new ForkJoin(0, 100L);
		ForkJoinTask<Long> result = pool.submit(task);
		
		long res = result.get();
		System.out.println(res);
	}
}
