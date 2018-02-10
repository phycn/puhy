/*
 * 引用类方法			类名::类方法
 * 引用特定对象的实例方法	特定对象:实例方法
 * 引用某类对象的实例方法	类名::实例方法
 * 引用构造器			类名::new
 */
package phy.oop;

public class LambdaReferenceTest {
	public static void main(String[] args) {
		//使用Lambda表达式创建ClassMethod对象
		ClassMethod classMethod1 = (str) -> Integer.valueOf(str);
		Integer i1 = classMethod1.convert("12");
		System.out.println(i1);
		
		//方法引用代替Lambda表达式：引用类方法
		//类名::类方法
		ClassMethod classMethod2 = Integer::valueOf;
		System.out.println(classMethod2.convert("123"));

		//实例方法的方法引用
		String str1 = "puhongyu";
		ObjRef objRef = str1::substring;
		System.out.println(objRef.fun(2));

	}
}

interface ClassMethod {
	Integer convert(String str);
}

interface ObjRef {
	String fun(int start);
}
