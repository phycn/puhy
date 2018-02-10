package phy.system;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;
import java.util.Properties;

public class SystemTest {
    
    public static void main(String[] args) throws IOException {
        
        //获取系统所有环境变量
        Map<String,String> env = System.getenv();
        for(String name : env.keySet()) {
            
            System.out.println(name + "---" + env.get(name));
        }
        
        //获取所有系统属性
        Properties p = System.getProperties();
        //将所有属性保存到文件中
        p.store(new FileOutputStream("E:\\phytest\\SystemTest.txt"), "System");
        //以XML文件保存
        p.storeToXML(new FileOutputStream("E:\\phytest\\SystemTest.xml"), "System");
        
        //获取系统当前时间
        System.out.println(System.currentTimeMillis());
    }
}
