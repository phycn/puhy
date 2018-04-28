package cn.puhy.highConcurrency.parallelAndAlgorithm;

public class FalseSharing implements Runnable {
	private final static int CORE = 4;
	private final static long ITERATION = 500L * 1000L * 1000L;
	private final int arrayIndex;
	
	private static VolatileLong[] longs = new VolatileLong[CORE];
	
	static {
		for(int i = 0; i < CORE; i++) {
			longs[i] = new VolatileLong();
		}
	}
	
	public FalseSharing(int arrayIndex) {
		this.arrayIndex = arrayIndex;
	}
	
	public static void runTest() throws InterruptedException {
		Thread[] threads = new Thread[CORE];
		for(int i = 0; i < CORE; i++) {
			threads[i] = new Thread(new FalseSharing(i));
		}
		
		for(Thread t : threads) {
			t.start();
			t.join();
		}
	}

	@Override
	public void run() {
		long i = ITERATION;
		while(i-- != 0) {
			longs[arrayIndex].value = i;
		}
	}
	
	public final static class VolatileLong {
		public volatile long value = 0L;
		public long p1, p2, p3, p4, p5, p6;
	}
	
	public static void main(String[] args) throws InterruptedException {
		
		final long start = System.currentTimeMillis();
		runTest();
		System.out.println(System.currentTimeMillis() - start);
	}
}
