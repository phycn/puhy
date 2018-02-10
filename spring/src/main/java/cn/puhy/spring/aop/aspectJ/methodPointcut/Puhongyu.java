package cn.puhy.spring.aop.aspectJ.methodPointcut;

import cn.puhy.spring.aop.aspectJ.methodParam.DotHaveAnno;
import cn.puhy.spring.aop.aspectJ.methodParam.HaveAnno;
import cn.puhy.spring.aop.aspectJ.targetClass.MyInterface;

@Anno1
public class Puhongyu implements Man, MyInterface {

	public void say() {
		System.out.println("蒲红宇说话");
	}
	
	@Anno1
	public void eat(String food) {
		System.out.println("蒲红宇吃" + food);
	}
	
	public void eat() {
		System.out.println("蒲红宇吃东西");
	}
	
	public void sleep(String num) {
		System.out.println("蒲红宇睡" + num + "小时");
	}
	
	public int getAge() {
		
		return 27;
	}
	
	//入参类型有注解修饰
	public void paramHaveAnno(HaveAnno ha) {
		System.out.println("我的入参有注解修饰");
	}
	
	//入参类型没有注解修饰
	public void paramDotHaveAnno(DotHaveAnno dha) {
		System.out.println("我的入参没有注解修饰");
	}
}
