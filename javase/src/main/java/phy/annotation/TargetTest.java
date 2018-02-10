package phy.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

@Documented //指定Annotation修饰的类将被javadoc工具提取成文档
@Target(ElementType.FIELD) //指定Annotation只能修饰成员变量
public @interface TargetTest {
    
}
