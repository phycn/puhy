package cn.puhy.spring.aop.aspectJ.methodPointcut;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class MethodPointcutAspect {
	
	//execution()语法
	//execution(<修饰符模式> <返回类型模式> <方法名模式>(<参数模式>) <异常模式>)
	//返回类型，方法名模式，参数模式为必选，其他为可选
	
	//	*	匹配任意字符，只能匹配一个
	//	..	匹配任意字符，可以匹配多个
	//	+	匹配指定类的所有类，必须跟在类后面
	
	//	public * *(..)				目标类的public方法
	//	* *To(..)					目标类所有以To为后缀的方法
	//	* cn.puhy..Man.*(..)			Man接口的所有方法，包括子类，不包括子类不是继承的方法
	//	* cn.puhy..Man+.*(..)		Man接口及其实现类的所有方法，包括子类不是继承的方法
	//	* cn.puhy.*(..)				cn.puhy包下所有类的所有方法
	//	* cn.puhy..*(..)				cn.puhy包及其子包下所有类的所有方法
	//	* cn.puhy..*.*Dao.find*(..)	cn.puhy包及其子包下所有后缀名为Dao的类，方法名前缀为find的方法
	//	* eat(String, int)			匹配eat方法，第一个入参为String，第二个入参为int
	//	* eat(String, *)				匹配eat方法，第一个入参为String，第二个入参为任意类型
	//	* eat(String, ..)			匹配eat方法，第一个入参为String，后面可以有任意个入参
	//	* eat(Object+)				匹配eat方法，入参为Object或子类
	
	@Before("@annotation(cn.puhy.spring.aop.aspectJ.methodPointcut.Anno1)")
	public void before() {	
		System.out.println("被Anno1注解修饰的方法");
	}
	
	@AfterReturning(value="execution(* Puhongyu.getAge())", returning="age")
	public void after(int age) {
		System.out.println("获取返回值：" + age);
	}
}
