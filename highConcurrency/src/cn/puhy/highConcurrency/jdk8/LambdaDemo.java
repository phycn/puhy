package cn.puhy.highConcurrency.jdk8;

import java.util.Arrays;

public class LambdaDemo {
	public static void main(String[] args) {
		int[] arr = {1,3,5,2,5,8};
		//->左半部分为参数，右半部分为实现体
		Arrays.stream(arr).forEach((x) -> System.out.println(x));
		//与上面效果一样
		Arrays.stream(arr).forEach(System.out::println);
	}
}
