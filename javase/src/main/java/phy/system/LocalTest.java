/*
    资源文件名
    baseName_language_country.properties
    baseName_language.properties
    baseName.properties
*/
package phy.system;

import java.text.MessageFormat;
import java.util.Date;
import java.util.Locale;
import java.util.ResourceBundle;

public class LocalTest {
    
    public static void main(String ... args) {
        
        //返回java支持的全部国家和语言
        Locale[] localeList = Locale.getAvailableLocales();
        for(Locale l : localeList) {
            
            System.out.println("国家/地区名：" +l.getDisplayCountry());
            System.out.println("国家/地区代码："+ l.getCountry());
            System.out.println("语言代码：" + l.getLanguage());
            System.out.println("-----------------------------------------");
        }
        
        //取得系统默认的
        Locale myLocale = Locale.getDefault();
        //加载资源文件,文件名为phy_zh_CN.proeprties，在phy/system目录下
        ResourceBundle bundle = ResourceBundle.getBundle("phy/system/phy", myLocale);
        System.out.println(bundle.getString("sb"));
        
        //使用MessageFormat处理包含占位符的字符串
        String msg = bundle.getString("msg");
        System.out.println(MessageFormat.format(msg, "phy", new Date()));
    }
}
