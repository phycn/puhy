package phy.io;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ReadFromProcess {
    
    public static void main(String ... args) throws Exception{
        
        //运行java命令，返回该命令的子进程
        Process p = Runtime.getRuntime().exec("1");
        //以p进程的错误流创建BufferedReader
        //这个错误流对本程序是输入流，对p进程则是输出流
        BufferedReader br = new BufferedReader(new InputStreamReader(p.getErrorStream()));
        String msg = "";
        while((msg = br.readLine()) != null) {
            System.out.println(msg);
        }
    }
}
