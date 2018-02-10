/*
    不适用于需要保持持久通信状态的交互式应用，只适用于一站式通信
*/

package phy.net.socket;

import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class HalfCloseServer {
    
    public static void main(String ... args) throws Exception {
        
        ServerSocket ss = new ServerSocket(30000);
        Socket s = ss.accept();
        PrintStream ps = new PrintStream(s.getOutputStream());
        ps.println("服务器的第一条消息");
        ps.println("服务器的第二条消息");
        //关闭socket的输出流，表明输出流已经结束
        s.shutdownOutput();
        Scanner sc = new Scanner(s.getInputStream());
        while(sc.hasNextLine()) {
            System.out.println(sc.nextLine());
        }
        sc.close();
        s.close();
        ss.close();
    }
}
