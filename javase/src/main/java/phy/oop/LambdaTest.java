/*
 * 函数式接口(只包含一个抽象方法)才能用Lambda表达式
 */
package phy.oop;

@FunctionalInterface	//检查接口必须是函数式接口
interface Eatable {
	void eat();
}

interface Flyable {
	void fly(String weather);
}

interface Addable {
	int add(int a, int b);
}

public class LambdaTest {
	//调用该方法需要Eatable对象
	public void eat(Eatable e) {
		System.out.println(e);
		e.eat();
	}
	//调用该方法需要Flyable对象
	public void fly(Flyable f) {
		System.out.println(f);
		f.fly("秋天");
	}
	//调用该方法需要Addable对象
	public void add(Addable a) {
		System.out.println(a);
		a.add(1, 2);
	}
	
	public static void main(String[] args) {
		LambdaTest test = new LambdaTest();
		//括号里为形参，因为eat()方法没有形参，所以为空，箭头后面为eat()方法实现
		test.eat(() -> System.out.println("12"));
		test.fly((weather) -> {
			System.out.println(weather);
		});
		test.add((a, b) -> a + b);
	}
}
