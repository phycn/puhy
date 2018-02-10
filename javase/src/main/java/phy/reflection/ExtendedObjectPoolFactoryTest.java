/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package phy.reflection;

import java.io.FileInputStream;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 *
 * @author Administrator
 */
public class ExtendedObjectPoolFactoryTest {
    
    //定义一个对象池，前面是对象名，后面是实际对象
    private Map<String, Object> objectPool = new HashMap<>();
    private Properties props = new Properties();
    
    //从指定属性文件中初始化Properties对象
    private void init(String fileName) throws Exception{
        
        FileInputStream fis = new FileInputStream(fileName);
        props.load(fis);
        
    }
    
    //定义创建对象的方法
    private Object createObject(String clazzName) throws Exception{
        
        Class<?> clazz = Class.forName(clazzName);
        return clazz.newInstance();
    }
    
    //该方法根据指定文件来初始化对象池
    //它会根据配置文件来创建对象
    public void initPool() throws Exception {
        
        for(String name : props.stringPropertyNames()) {
            
            //每取出一个key-value对，如果key不包含%，表明是根据value来创建对象，调用createObject创建对象，并添加到对象池
            if(!name.contains("%")) {
                objectPool.put(name, createObject(props.getProperty(name)));
            }
        }
    }
    
    public void initProperty() throws Exception {
        
        for(String name : props.stringPropertyNames()) {
            
            ///%前面为对象名，后面为方法名，调用方法
            if(name.contains("%")) {
                
               String[] objAndProp = name.split("%");
               //取出需要设置字段值的目标对象
               Object target = getObject(objAndProp[0]);
               String mtdName = objAndProp[1];
               //通过target的getClass方法获取它的实现类所对应的Class对象
               Class<?> targerClazz = target.getClass();
               //获取方法
               Method mtd = targerClazz.getMethod(mtdName, String.class);
               //将props.getProperty(name)的属性值作为调用方法的实参
               mtd.invoke(target, props.getProperty(name));
            }
        }
    }

    private Object getObject(String name) {
        
        //从objectPool中取出指定name对应的对象
        return objectPool.get(name);
    }
    
    public static void main(String[] args) throws Exception {
        
        ExtendedObjectPoolFactoryTest epf = new ExtendedObjectPoolFactoryTest();
        epf.init("extObj.txt");
        epf.initPool();
        epf.initProperty();
        System.out.println(epf.getObject("a"));
    }
}
