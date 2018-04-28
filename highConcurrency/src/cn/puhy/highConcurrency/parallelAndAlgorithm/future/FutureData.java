package cn.puhy.highConcurrency.parallelAndAlgorithm.future;

/**
 * 真实数据RealData的代理
 * @author puhongyu
 *
 */
public class FutureData implements Data {
	
	private RealData realData = null;
	private boolean isReady = false;

	@Override
	public synchronized String getResult() {
		while(!isReady) {
			try {
				//一直等待，直到RealData被注入
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		return realData.getResult();
	}
	
	public synchronized void setResult(RealData realData) {
		if(isReady) {
			return;
		}
		
		this.realData = realData;
		isReady = true;
		//RealData被注入，通知getResult
		notifyAll();
	}
}
