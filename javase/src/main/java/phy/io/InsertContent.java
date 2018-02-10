package phy.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;

public class InsertContent {
  
    private static void insert(String fileName, long pos, String insertContent) throws FileNotFoundException, IOException {
        
        RandomAccessFile raf = new RandomAccessFile(fileName, "rw");
        //创建临时文件用于保存插入后的数据
        File temp = File.createTempFile("tmp", null);
        FileOutputStream fos = new FileOutputStream(temp);
        FileInputStream fis = new FileInputStream(temp);
        //将指针移到指定位置，准备插入内容
        raf.seek(pos);
        byte[] buf = new byte[32];
        while(raf.read(buf) > 0) {
            
            //将插入点后的数据保存
            fos.write(buf);
        }
        raf.seek(pos);
        //追加需要插入的内容
        raf.write(insertContent.getBytes());
        while(fis.read(buf) > 0) {
            //追加临时文件中的内容
            raf.write(buf);
        }
        raf.close();
        fos.close();
        fis.close();
    }
    
    public static void main(String ... args) throws IOException {
        
        insert("E:\\phytest\\out.txt", 5, "(插入内容)");
    }
        
}
