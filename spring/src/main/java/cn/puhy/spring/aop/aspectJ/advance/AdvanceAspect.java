package cn.puhy.spring.aop.aspectJ.advance;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

@Aspect
public class AdvanceAspect {

    //&&为与运算，跟java的&&，||，！相似
    @Before("NamePointcut.test3() && NamePointcut.test2()")
    public void before(JoinPoint jp) {
        System.out.println("蒲红宇学什么？");
    }

    /**
     * 访问连接点信息，ProceedingJoinPoint只能用在环绕增强
     * @param pjp
     * @throws Throwable
     */
    @Around("execution(* cn.puhy..Puhongyu.study(..))")
    public void around(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("环绕增强开始");
        //获取连接点方法运行时的入参列表
        Object[] args = pjp.getArgs();
        for(Object o : args) {
            System.out.println(o);
        }
        //getSignature()获取方法签名对象，就是匹配到的方法
        System.out.println(pjp.getSignature());
        //getTarget()获取连接点对象
        System.out.println(pjp.getTarget().toString());
        //getThis()获取代理对象本身
        System.out.println(pjp.getThis());

        //执行目标对象方法
        pjp.proceed();
        System.out.println("环绕增强开始");
    }

    /**
     * 绑定连接点方法入参
     * @param param1
     * @param param2
     */
    @Before("execution(* cn.puhy..Puhongyu.bindJoinPointParam(..)) && args(param1, param2)")
    public void bindJoinPointParam(String param1, int param2) {
        System.out.println("获取到第一个参数：" + param1);
        System.out.println("获取到第二个参数：" + param2);
    }

    /**
     *  绑定代理对象，获得对象实例，所有对象类型为Puhongyu的都会匹配
     * @param phy
     */
    @Before("this(phy)")
    public void bindProxyObject(Puhongyu phy) {
        System.out.println("我是绑定代理对象测试");
    }

    /**
     * 绑定类注解对象，标注了Chengxuyuan注解的对象实例会被匹配
     * @param cxy
     */
    @Before("@within(cxy)")
    public void bindAnnoObject(Chengxuyuan cxy) {
        System.out.println(cxy.getClass().getName());
        System.out.println("我是绑定类注解对象测试");
    }

    /**
     * 绑定返回值
     * @param age
     */
    @AfterReturning(value="execution(* *.getAge())", returning = "age")
    public void bindReturnValue(int age) {
        System.out.println("蒲红宇今年" + age + "岁");
    }

    @AfterThrowing(value="execution(* *.bindException())", throwing = "e")
    public void bindException(Exception e) {
        System.out.println("获取绑定的异常信息：" + e.getMessage());
    }
}
