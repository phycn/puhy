package phy.io;

import java.io.FileInputStream;

public class FileInputStreamTest {
    
    public static void main(String ... args) throws Exception {
        
        //读取文件创建字节输入流
        FileInputStream fis = new FileInputStream("E:\\PHY\\study\\codes\\17\\17.3\\HalfClose\\Client.java");
        //创建长度为1024的字节数组，用于读取字节，相当于容器
        byte[] buff = new byte[2];
        //用于保存实际读取的字节数
        int hasRead = 0;
        //循环读取，将读取到的放入buff数组里
        while((hasRead = fis.read(buff)) > 0) {
            //将字节数组转换成字符串输出
            System.out.print(new String(buff, 0, hasRead));
        }
        fis.close();
    }
}
