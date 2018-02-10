package cn.puhy.spring.aop.aspectJ.advance;

import org.aspectj.lang.annotation.Pointcut;

/**
 * 命名切点
 */
public class NamePointcut {

    //通过@Pointcut命名切点，切点名称为test1，private为该切点只能在本切面类中使用
    @Pointcut("execution(* *())")
    private void test1() {

    }

    //protected为该切点可以在当前包中的切面类、子切面类中使用
    @Pointcut("execution(* cn.puhy..Puhongyu.studyRedis(..))")
    protected void test2() {

    }

    //public为该切点可以在任何切面类中使用
    @Pointcut("within(cn.puhy.spring.aop.aspectJ.advance.Puhongyu)")
    public void test3() {

    }
}
