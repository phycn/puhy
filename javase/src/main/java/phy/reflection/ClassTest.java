/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package phy.reflection;

//使用两个注释修饰该类

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import phy.util.RedirectOut;

@SuppressWarnings(value="unchecked")
//@Deprecated
public class ClassTest {
    
    //私有构造器
    private ClassTest() {
        
    }
    
    //有参数的构造器
    public ClassTest(String name) {
        System.out.println("有参数的构造器");
    }
    
    //无参数的info方法
    public void info() {
        System.out.println("无参数的info方法");
    }
    
    //有参数的info方法
    public void info(String str) {
        System.out.println("有参数的info方法");
    }

    private static class Methods {

        public Methods() {
        }
    }
    
    //定义一个内部类
    class Inner {}
    
    public static void main(String[] args) throws Exception {
        
        RedirectOut.out();
        
        //获得Class对象
        Class<ClassTest> clazz = ClassTest.class;
        //获取全部构造器
        Constructor[] ctors = clazz.getDeclaredConstructors();
        System.out.println("ClassTest的全部构造器：");
        for(Constructor c : ctors) {
            System.out.println(c);
        }
        System.out.println("-----------------------------------------------------");
        //获取全部pulbic构造器
        Constructor[] publicCtors = clazz.getConstructors();
        System.out.println("ClassTest的全部public构造器：");
        for(Constructor c : publicCtors) {
            System.out.println(c);
        }
        
        System.out.println("-----------------------------------------------------");
        //获取全部public方法，包含从Object继承来的方法
        Method [] m = clazz.getMethods();
        System.out.println("ClassTest的全部public方法：");
        for(Method me : m) {
            System.out.println(me);
        }
        
        System.out.println("-----------------------------------------------------");
        //获取指定方法
        System.out.println("ClassTest里带一个字符串参数的info方法为：" + clazz.getMethod("info", String.class));
        
        System.out.println("-----------------------------------------------------");
        //获取全部注释
        Annotation[] anns = clazz.getAnnotations();
        System.out.println("ClassTest的全部注释：");
        for(Annotation a : anns) {
            System.out.println(a);
        }
        
        System.out.println("-----------------------------------------------------");
        //获取内部类
        System.out.println("ClassTest的全部内部类：");
        Class<?>[] inners = clazz.getDeclaredClasses();
        for(Class c : inners) {
            System.out.println(c);
        }
        
        System.out.println("-----------------------------------------------------");
        //使用Class.forName()方法加载内部类
        Class inClazz = Class.forName("phy.reflection.ClassTest$Inner");
        //通过getDeclaringClass()获得外部类
        System.out.println("inClazz的外部类：" + inClazz.getDeclaringClass());
    }
}
