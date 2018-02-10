package phy.exception;

import java.io.BufferedReader;
import java.io.FileReader;

public class AutoCloseTest {
    
    public static void main(String ... args) throws Exception{
        
        //try语句会自动关闭资源，资源必须是实现了AutoCloseable或Closeable接口
        //下面bf会自动关闭，不必在finally里关闭
        try(BufferedReader bf = new BufferedReader(new FileReader("1.txt"))) {
            
        }
    }
}
