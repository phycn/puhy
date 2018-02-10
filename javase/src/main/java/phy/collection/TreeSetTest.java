/*
 * 	需要有序的set时，用TreeSet,否则使用HashSet,LinkedHashSet遍历会更快,set的元素不能重复
 */
package phy.collection;

import java.util.TreeSet;

public class TreeSetTest {
	
	public static void main(String[] args) {
		
		TreeSet ts = new TreeSet();
		ts.add(5);
		ts.add(-7);
		ts.add(9);
		//已经排好序
		System.out.println(ts);
		//第一个元素
		System.out.println(ts.first());
		//最后一个元素
		System.out.println(ts.last());
		//返回小于4的子集，不包含4
		System.out.println(ts.headSet(4));
		//返回大于5的子集，包含5
		System.out.println(ts.tailSet(5));
		//返回大于等于1，小于6的子集
		System.out.println(ts.subSet(1, 6));
	}
}
