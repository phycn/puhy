package phy.oop;

import java.lang.ref.WeakReference;

public class ReferenceTest {
	public static void main(String[] args) {
		
		String str = new String("phy");
		//创建一个弱引用，让弱引用引用到str
		WeakReference wr = new WeakReference(str);
		str = null;
		//取出弱引用引用的对象
		System.out.println(wr.get());
		System.gc();
		System.runFinalization();
		System.out.println(wr.get());
	}
}
