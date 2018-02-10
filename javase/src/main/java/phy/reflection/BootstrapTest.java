/*
    Bootstrap负责加载java的核心类
 */

package phy.reflection;

import java.net.URL;

/**
 *
 * @author Administrator
 */
public class BootstrapTest {
    
    public static void main(String[] args) {
        //获取根类加载器加载的URL数组
        URL[] urls = sun.misc.Launcher.getBootstrapClassPath().getURLs();
        for(URL a : urls) {
            //toExternalForm()转为字符串，与toString()相同
            System.out.println(a.toExternalForm());
        }
    }        
}
