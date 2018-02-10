package phy.system;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RgexTest {
    
    public static void main(String ... args) {
        
        String a = "p12345678901p";
        // \w为匹配所有的单词字符,下面使用的是贪婪模式，直到不能匹配为止，所以遇到，停止匹配
        //System.out.println(a.replaceFirst("\\w*", "p"));
        
        //将一个字符串编译成Pattern对象
        Pattern p = Pattern.compile("1\\d{10}");
        //使用Pattern对象创建Matcher对象
        Matcher m = p.matcher(a);
        while(m.find()) {
        	
        	System.out.println(m.group());
        }
        
    }
}
