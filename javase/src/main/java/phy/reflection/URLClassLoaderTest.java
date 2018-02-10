/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package phy.reflection;

import java.net.URL;
import java.net.URLClassLoader;
import java.sql.Connection;
import java.sql.Driver;
import java.util.Properties;

public class URLClassLoaderTest {
    
    private static Connection conn;
    
    public static Connection getConn(String url, String user, String pass) throws Exception {
        
        if(conn == null) {
            URL[] urls = {new URL("file:mysql.jar")};
            URLClassLoader myClassLoader = new URLClassLoader(urls);
            //加载MySQL的JDBC驱动，并创建默认实例
            Driver driver = (Driver)myClassLoader.loadClass("com.mysql.jdbc.Driver").newInstance();
            Properties props = new Properties();
            props.setProperty("user", user);
            props.setProperty("pass", pass);
            //调用Driver对象的connect方法来取得数据库连接
            conn = driver.connect(user, props);
        }
        return conn;
    }
}
