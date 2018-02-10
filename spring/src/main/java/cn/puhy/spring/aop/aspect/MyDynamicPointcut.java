package cn.puhy.spring.aop.aspect;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import org.springframework.aop.ClassFilter;
import org.springframework.aop.support.DynamicMethodMatcherPointcut;

/**
 * 动态切点
 * @author puhongyu
 *
 */
public class MyDynamicPointcut extends DynamicMethodMatcherPointcut {
	
	private static List<String> songList = new ArrayList<>();
	static {
		songList.add("七里香");
		songList.add("听妈妈的话");
		songList.add("菊花台");
	}

	//静态检查
	@Override
	public ClassFilter getClassFilter() {
		return new ClassFilter() {

			@Override
			public boolean matches(Class<?> clazz) {
				System.out.println("---------------------------------------");
				System.out.println("调用getClassFilter静态检查：" + clazz.getName());
				//判断两个类是否相同，或是父类，接口关系
				//只匹配Zhoujielun
				return Zhoujielun.class.isAssignableFrom(clazz);
			}
		};
	}
	
	//这也是静态检查，只会在方法第一次调用时执行
	@Override
	public boolean matches(Method method, Class<?> targetClass) {
		System.out.println("---------------------------------------");
		System.out.println("调用matches静态检查：" + method.getName());
		return "sing".equals(method.getName());
	}

	//动态检查
	@Override
	public boolean matches(Method method, Class<?> targetClass, Object... args) {
		System.out.println("---------------------------------------");
		System.out.println("调用matches动态检查：" + method.getName());
		//根据方法参数进行匹配，实现动态检查
		return songList.contains(args[0]);
	}
}
