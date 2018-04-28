package cn.puhy.highConcurrency.parallelAndAlgorithm.future;

/**
 * 真实数据
 * @author puhongyu
 *
 */
public class RealData implements Data {

	private String result;
	
	public RealData(String str) throws InterruptedException {
		StringBuffer sb = new StringBuffer();
		sb.append(str);
		sb.append(str);
		//代替一个慢动作
		Thread.sleep(1000);
		
		this.result = sb.toString();
	}
	
	@Override
	public String getResult() {
		return result;
	}
}
