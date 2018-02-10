package cn.puhy.mybatis.interceptor;

import java.lang.reflect.Method;
import java.util.Properties;

import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Plugin;
import org.apache.ibatis.plugin.Signature;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;

/**
 * Executor
 * ParameterHandler
 * ResultSetHandler
 * StatementHandler
 */
@Intercepts({
	//type为设置拦截的接口，Executor、ParameterHandler、ResultSetHandler、StatementHandler之一
	//method为拦截接口中的方法，前面4种接口，query为所有查询
	//args为拦截方法的参数类型数组，前面4种接口中的方法
	@Signature(args = { MappedStatement.class, Object.class, RowBounds.class, ResultHandler.class }, 
						method = "query", 
						type = Executor.class)
})
public class MyInterceptor implements Interceptor {

	@Override
	public Object intercept(Invocation invocation) throws Throwable {

		//getTarget()获取当前被拦截的对象
		Object target = invocation.getTarget();
		System.out.println(target.getClass().getName());
		//getMethod()获取当前被拦截的方法
		Method method = invocation.getMethod();
		//getArgs()获取当前被拦截方法的参数
		Object[] args = invocation.getArgs();
		for(Object arg : args) {
			if(arg != null) {
				System.out.println(arg.getClass().getName());
			}
		}
		System.out.println("拦截开始");
		//proceed()执行被拦截的方法
		Object result = invocation.proceed();
		System.out.println("拦截结束");
		return result;
	}

	@Override
	public Object plugin(Object target) {
		return Plugin.wrap(target, this);
	}

	@Override
	public void setProperties(Properties properties) {
		
	}
}
