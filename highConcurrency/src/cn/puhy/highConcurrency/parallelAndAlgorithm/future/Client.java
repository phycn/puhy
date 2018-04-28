package cn.puhy.highConcurrency.parallelAndAlgorithm.future;

public class Client {
	
	public Data request(String str) {
		
		FutureData future = new FutureData();
		new Thread() {
			public void run() {
				try {
					RealData real = new RealData(str);
					future.setResult(real);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}.start();
		//FutureData会被立即返回
		return future;
	}
}
