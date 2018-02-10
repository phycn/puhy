package phy.net.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

public class ClientMulti {
    
    public static void main(String[] args) throws IOException {
        
        Socket s = new Socket("127.0.0.1", 30000);
        new Thread(new ClientMultiThread(s)).start();
        //获取Socket对应的输出流，向服务器发消息
        PrintStream ps = new PrintStream(s.getOutputStream());
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = null;
        while((line = br.readLine()) != null) {
            ps.println(line);
        }
    }
}
