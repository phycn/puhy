package phy.io;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

public class WriteToProcess {
    
    public static void main(String ... args) throws IOException {
        
        Process p = Runtime.getRuntime().exec("java Read");
        //以P进程的输出流创建PrintStream对象
        //这个输出流对程序是输出流，对p进程是输入流
        PrintStream ps = new PrintStream(p.getOutputStream());
        //向Read类写入内容，内容会写到out.txt文件中
        ps.println("测试");
        ps.println(new WriteToProcess());
        
        ps.close();
    }
}

class Read {
    
    public static void main(String ... args) throws FileNotFoundException {
        
    	//此处的System.in不会是键盘输入了，而是其他进程写入本进程的内容
        Scanner sc = new Scanner(System.in);
        PrintStream ps = new PrintStream(new FileOutputStream("E:\\phytest\\out.txt"));
        sc.useDelimiter("\n");
        while(sc.hasNext()) {
            
            ps.println(sc.next());
        }
        ps.close();
    }
}
