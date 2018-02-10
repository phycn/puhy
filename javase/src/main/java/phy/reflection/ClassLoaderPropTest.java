/*
    扩展类加载器负责加载JRE的扩展目录（%JAVA_HOME%/jre/lib/ext中JAR包的类）
 */

package phy.reflection;

import java.io.IOException;
import java.net.URL;
import java.util.Enumeration;

/**
 *
 * @author Administrator
 */
public class ClassLoaderPropTest {
    
    public static void main(String[] args) throws IOException {
        
        //获取系统类加载器
        ClassLoader systemLoader = ClassLoader.getSystemClassLoader();
        System.out.println("系统类加载器：" + systemLoader);
        
        Enumeration<URL> eml = systemLoader.getResources("");
        while(eml.hasMoreElements()) {
            System.out.println(eml.nextElement());
        }
        
        //获取系统类加载器的父类加载器，得到扩展类加载器
        ClassLoader extensionLoader = systemLoader.getParent();
        System.out.println("扩展类加载器：" + extensionLoader);
        System.out.println("扩展类加载器的加载路径：" + System.getProperty("java.ext.dirs"));
    }
}
