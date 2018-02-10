package phy.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@interface Test {
    //定义成员变量
    String name();
    int age();
    String a() default "123"; //指定初始值
}

public class CustomAnnotationTest {
    
    @Test(name="phy",age=25) //使用带成员变量的Annotation时需要为成员变量赋值
    public void info() {
        System.out.println(111);
    }
}
