package phy.io;

import java.io.RandomAccessFile;

public class RandomAccessFileTest {
    
    public static void main(String ... args) throws Exception {
        
        //以只读方式打开文件
        RandomAccessFile raf = new RandomAccessFile("D:\\NetBeansProjects\\PHY\\src\\phy\\io\\RandomAccessFileTest.java", "r");
        //获取当前指针的位置，初始为0
        System.out.println(raf.getFilePointer());
        //移动指针的位置
        raf.seek(300);
        byte[] buf = new byte[32];
        while(raf.read(buf) > 0) {
            
            System.out.print(new String(buf));
        }           
        raf.close();
    }
}
