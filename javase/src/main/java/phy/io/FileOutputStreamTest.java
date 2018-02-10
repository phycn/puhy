package phy.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileOutputStreamTest {
    
    public static void main(String ... args) throws IOException {
        
        //创建文件输入流
        FileInputStream fis = new FileInputStream("E:\\phytest\\testFile.txt");
        //创建文件输出流
        FileOutputStream fos = new FileOutputStream("E:\\phytest\\testFile1.txt");
        byte[] bbuf = new byte[32];
        int hasRead = 0;
        while((hasRead = fis.read(bbuf)) > 0) {
            //写入文件输出流，读了多少，就写多少
            fos.write(bbuf, 0, hasRead);
        }
        fos.close();
        fis.close();
    }
}
