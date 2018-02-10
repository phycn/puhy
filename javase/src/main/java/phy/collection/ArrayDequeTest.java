/*
 * 堆栈后进先出
 * push(e)=addFirst(e)
 * pop()=removeFirst()
 * peek()=peekFirst()
 * 程序需要使用栈数据结构时，优先使用ArrayDeque活LinkedList
*/
package phy.collection;

import java.util.ArrayDeque;

public class ArrayDequeTest {
	public static void main(String[] args) {
		ArrayDeque stack = new ArrayDeque();
		// 依次将三个元素push入"栈"
		stack.push("疯狂Java讲义");
		stack.push("轻量级Java EE企业应用实战");
		stack.push("疯狂Android讲义");
		// 输出：[疯狂Java讲义, 轻量级Java EE企业应用实战 , 疯狂Android讲义]
		System.out.println(stack);
		// 根据后进先出原则，获取到的是最后一个元素
		System.out.println(stack.peek());
		// 依然输出：[疯狂Java讲义, 轻量级Java EE企业应用实战 , 疯狂Android讲义]
		System.out.println(stack);
		// 根据后进先出原则，删除的是最后一个元素
		System.out.println(stack.pop());
		// 输出：[疯狂Java讲义, 轻量级Java EE企业应用实战]
		System.out.println(stack);
	}
}
