/*
 * 读取文本内容通常用BufferedReader
 */

package phy.io;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class BufferedReaderTest {
    
    public static void main(String ... args) throws IOException {
        
        //将System.in对象转换为字符流
        InputStreamReader isr = new InputStreamReader(new FileInputStream("C:\\Users\\Administrator\\Desktop\\1.txt"));
        //包装成缓冲流
        BufferedReader br = new BufferedReader(isr);
        String buffer = null;
        while((buffer = br.readLine()) != null) {
            String[] a = buffer.split(" ");
            //System.out.println(a[2].toLowerCase());
            if(a[2].contains("_")) {
            	int index_ = a[2].indexOf("_");
            	String q = a[2].substring(0, index_).toLowerCase();
            	String z = a[2].substring(index_ + 1, index_ + 2).toUpperCase();
            	String h = a[2].substring(index_ + 2).toLowerCase();
            	System.out.println(q + z + h);
            }
            else {
            	System.out.println(a[2].toLowerCase());
            }
        }
        br.close();
        isr.close();
    }
}
