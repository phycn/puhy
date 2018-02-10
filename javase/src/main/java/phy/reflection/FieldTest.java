/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package phy.reflection;

import java.lang.reflect.Field;

class Person {
    private String name;
    private int age;
    
    @Override
    public String toString() {
        
        return name + age;
    }
}

public class FieldTest {
    
    public static void main(String[] args) throws Exception {
        
        Person p = new Person();
        Class<?> clazz = p.getClass();
        //获取所有字段
        Field[] fields = clazz.getDeclaredFields();
        for(Field field : fields) {
            System.out.println(field);
        }
        
        //获取字段名为name的字段
        Field nameField = clazz.getDeclaredField("name");
        //设置通过反射访问该字段时取消访问权限检查
        nameField.setAccessible(true);
        //调用set方法为p对象的name字段设置值
        nameField.set(p, "phy");
        
        System.out.println(p);
    }
}
