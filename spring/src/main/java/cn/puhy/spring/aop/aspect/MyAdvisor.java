package cn.puhy.spring.aop.aspect;

import java.lang.reflect.Method;

import org.springframework.aop.ClassFilter;
import org.springframework.aop.support.StaticMethodMatcherPointcutAdvisor;

/**
 * 切面
 * @author puhongyu
 *
 */
public class MyAdvisor extends StaticMethodMatcherPointcutAdvisor {

	//切点类匹配规则，匹配哪个类
	@Override
	public ClassFilter getClassFilter() {
		return new ClassFilter() {
			@Override
			public boolean matches(Class<?> clazz) {
				return Zhoujielun.class.isAssignableFrom(clazz);
			}
		};
	}

	//切点方法匹配规则，匹配哪个方法
	@Override
	public boolean matches(Method method, Class<?> targetClass) {
		return "sing".equals(method.getName());
	}
}
