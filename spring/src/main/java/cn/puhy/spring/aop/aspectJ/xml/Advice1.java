package cn.puhy.spring.aop.aspectJ.xml;

import org.aspectj.lang.ProceedingJoinPoint;

/**
 * 增强
 */
public class Advice1 {

    public void before() {
        System.out.println("我是前置增强，😁");
    }

    public void after() {
        System.out.println("我是后置增强，🙄");
    }

    //环绕增强
    public void around(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("环绕增强前。。。");
        pjp.proceed();
        System.out.println("环绕增强后。。。");
    }

    public void afterReturning(int age) {
        System.out.println("获取到的返回参数：" + age);
    }
}
