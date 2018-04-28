package cn.puhy.highConcurrency.parallelAndAlgorithm.future;

public class Main {
	public static void main(String[] args) throws InterruptedException {
		Client client = new Client();
		Data data = client.request("phy");
		System.out.println("请求完毕");
		//模拟做其他事情
		Thread.sleep(2000);
		//异步返回
		System.out.println("真实数据：" + data.getResult());
	}
}
