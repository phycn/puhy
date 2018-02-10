package phy.io;

import java.io.FileWriter;
import java.io.IOException;

public class FileWriterTest {
    
    public static void main(String ... args) throws IOException {
        
        FileWriter fw = new FileWriter("E:\\phytest\\testFile.txt");
        fw.write("你他吗是傻逼");
        fw.close();
    }
}
