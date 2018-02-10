package phy.io;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileReaderTest {
    
    public static void main(String ... args) throws FileNotFoundException, IOException {
        
        //读取文件获取字符流
        FileReader fr = new FileReader("C:\\Users\\Administrator\\Desktop\\1.txt");
        //读取字符的数组
        char[] cbuf = new char[16];
        int hasRead = 0;
        while((hasRead = fr.read(cbuf)) > 0) {
            System.out.println(new String(cbuf));
        }
        fr.close();
    }
}
