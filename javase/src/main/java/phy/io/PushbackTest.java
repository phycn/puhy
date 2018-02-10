package phy.io;

import java.io.FileReader;
import java.io.PushbackReader;

public class PushbackTest {
    
    public static void main(String ... args) throws Exception {
        
        //创建一个指定推回缓冲区长度为64的PushbackReader对象
        PushbackReader pr = new PushbackReader(new FileReader("E:\\phytest\\testFile.txt"), 64);
        
        char[] buf = new char[2];
        //用于保存上次读取的字符串内容
        String lastContent = "";
        while(pr.read(buf) > 0) {
            
            String content = new String(buf);
            int targetIndex = 0;
            //将上次读取字符串和本次读取的拼串起来查看是否包含目标字符串
            if((targetIndex = (lastContent + content).indexOf("傻逼呀")) > 0) {
                
                //将本次内容和上次内容一起推回缓冲区
                pr.unread((lastContent + content).toCharArray());
                //读取指定长度的内容（就是目标字符串之前的内容）
                int len = targetIndex > 32 ? 32 : targetIndex;
                //read方法读取的是缓冲区内的
                pr.read(buf, 0, len);
                System.out.println(new String(buf, 0, len));
                System.exit(0);
            }
            else {
                //System.out.println(lastContent);
                lastContent = content;
            }
        }
    }
}
