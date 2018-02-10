package phy.collection;

import java.util.TreeMap;

public class TreeMapTest
{
	public static void main(String[] args) 
	{
		TreeMap tm = new TreeMap();
		tm.put(1 , "轻量级Java EE企业应用实战");
		tm.put(-2 , "疯狂Java讲义");
		tm.put(3 , "疯狂Android讲义");
		System.out.println(tm);
		//返回该TreeMap的第一个Entry对象
		System.out.println(tm.firstEntry());
		//返回该TreeMap的最后一个key值
		System.out.println(tm.lastKey());
		//返回该TreeMap的比new R(2)大的最小key值。
		System.out.println(tm.higherKey(-1));
		//返回该TreeMap的比new R(2)小的最大的key-value对。
		System.out.println(tm.lowerEntry(-1));
		//返回该TreeMap的子TreeMap
		System.out.println(tm.subMap(0 , 2));
	}
}
