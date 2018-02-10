package phy.net.socket;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
      
    public static void main(String[] args) throws Exception {
        
        //创建一个ServerSocket，用于监听客户端Socket的连接请求
        ServerSocket ss = new ServerSocket(30000);
        //采用循环不断地接收来自客户端的请求
        while(true) {
            
            //每当接收到客户端Socket的请求时，服务器端也对应产生一个Socket
            Socket s = ss.accept();
            //将Socket对应的输出流包装成PrintStream
            PrintStream ps = new PrintStream(s.getOutputStream());
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            //向客户端发消息
            while(br.readLine() != null) {
                ps.println(br.readLine());
            }
            //关闭流和Socket
            //ps.close();
            //s.close();
        }
    }
}
