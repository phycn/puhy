package phy.net.socket;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class HalfCloseClient {
    
    public static void main(String ... args) throws IOException {
        
        Socket s = new Socket("127.0.0.1", 30000);
        Scanner sc = new Scanner(s.getInputStream());
        while(sc.hasNextLine()) {
            System.out.println(sc.nextLine());
        }
        s.shutdownInput();
        PrintStream ps = new PrintStream(s.getOutputStream());
        ps.println("客户端的第一条消息");
        ps.println("客户端的第二条消息");
        ps.close();
        sc.close();
        s.close();
    }
}
