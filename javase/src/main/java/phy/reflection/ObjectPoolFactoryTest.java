/*
    使用反射创建对象：
        1.使用Class对象的newInstance()方法来创建该Class对象对应类的实例，要求该类有默认构造器
        2.先使用Class对象获取指定的Constructor对象，再调用Constructor对象的newInstance()方法来创建实例，可以选择指定构造器来创建实例
 */

package phy.reflection;

import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import phy.util.RedirectOut;

/**
 *
 * @author Administrator
 */
public class ObjectPoolFactoryTest {
    
    //定义一个对象池，前面是对象名，后面是实际对象
    private Map<String, Object> objectPool = new HashMap<>();
    
    //定义创建对象的方法
    private Object createObject(String clazzName) throws Exception {
        
        Class<?> clazz = Class.forName(clazzName);
        return clazz.newInstance();
    }
    
    //根据配置文件创建对象
    public void initPool(String fileName) throws Exception {
        
        FileInputStream fis = new FileInputStream(fileName);
        Properties props = new Properties();
        props.load(fis);
        for(String name : props.stringPropertyNames()) {
            objectPool.put(name, createObject(props.getProperty(name)));
        }
    }
    
    public Object getObject(String name) {
        
        return objectPool.get(name);
    }
    
    public static void main(String[] args) throws Exception {
        
        RedirectOut.out();
        
        ObjectPoolFactoryTest pf = new ObjectPoolFactoryTest();
        pf.initPool("obj.txt");
        System.out.println(pf.getObject("a"));
    }
}
