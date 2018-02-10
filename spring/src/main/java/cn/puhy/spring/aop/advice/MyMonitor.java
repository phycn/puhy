package cn.puhy.spring.aop.advice;

import org.aopalliance.intercept.MethodInvocation;
import org.springframework.aop.support.DelegatingIntroductionInterceptor;

public class MyMonitor extends DelegatingIntroductionInterceptor implements Monitorable {
	
	private ThreadLocal<Boolean> MonitorMap = new ThreadLocal<>();

	@Override
	public Object invoke(MethodInvocation mi) throws Throwable {
		
		Object obj = null;
		if(MonitorMap.get() != null && MonitorMap.get()) {
			System.out.println("开始时间：" + System.currentTimeMillis());
			obj = super.invoke(mi);
			System.out.println("结束时间：" + System.currentTimeMillis());
		}
		else {
			obj = super.invoke(mi);
		}
		return obj;
	}

	@Override
	public void setTime(boolean flag) {
		MonitorMap.set(flag);
	}
}
