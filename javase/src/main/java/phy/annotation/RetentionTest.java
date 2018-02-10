package phy.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME) //编译器将把Annotation记录在class文件，运行时JVM会保留，可以通过反射获取
//@Retention(RetentionPolicy.CLASS) 记录在class文件，JVM不保留
//@Retention(RetentionPolicy.SOURCE) 只保留在源代码中
public @interface RetentionTest {
    
}
