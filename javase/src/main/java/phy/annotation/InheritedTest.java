package phy.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@interface Inheritable {}

@Inheritable //使用@Inheritable修饰的类，它的子类也会被@Inheritable修饰
class Base {
    
}

public class InheritedTest extends Base {
    
    public static void main(String[] args) {
        
        //判断InheritedTest类是否有@Inheritable修饰
        System.out.println(InheritedTest.class.isAnnotationPresent(Inheritable.class));
    }
}
