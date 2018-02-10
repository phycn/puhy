package phy.io;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

public class RedirectOut {
    
    public static void main(String ... args) throws FileNotFoundException {
        
        PrintStream ps = new PrintStream(new FileOutputStream("E:\\phytest\\out.txt"));
        //将标准输出重定向到ps输出流
        System.setOut(ps);
        System.out.println("重定向测试");
    }
}
