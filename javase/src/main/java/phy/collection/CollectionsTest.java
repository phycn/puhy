package phy.collection;

import java.util.ArrayList;
import java.util.Collections;

public class CollectionsTest {
	public static void main(String[] args) {
		ArrayList nums = new ArrayList();
		nums.add(2);
		nums.add(-5);
		nums.add(3);
		nums.add(0);
		// 输出:[2, -5, 3, 0]
		System.out.println(nums);
		// 将List集合元素的次序反转
		Collections.reverse(nums);
		// 输出:[0, 3, -5, 2]
		System.out.println(nums);
		// 将List集合元素的按自然顺序排序
		Collections.sort(nums);
		// 输出:[-5, 0, 2, 3]
		System.out.println(nums);
		// 将List集合元素的按随机顺序排序
		Collections.shuffle(nums);
		// 每次输出的次序不固定
		System.out.println(nums);
		// 输出最大元素
		System.out.println(Collections.max(nums));
		// 输出最小元素
		System.out.println(Collections.min(nums));
		// 将nums中的0使用1来代替
		Collections.replaceAll(nums, 0, 1);
		// 输出:[2, -5, 3, 1]
		System.out.println(nums);
		// 判断-5 在List集合中出现的次数，返回1
		System.out.println(Collections.frequency(nums, -5));
		// 对nums集合排序
		Collections.sort(nums);
		// 输出:[-5, 1, 2, 3]
		System.out.println(nums);
		// 只有排序后的List集合才可用二分法查询，输出3
		System.out.println(Collections.binarySearch(nums, 3));
	}
}
