package phy.net.socket;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;

public class ServerMulti {
    
    public static HashMap<Socket,Integer> map = new HashMap<>();
    
    public static void main(String[] args) throws IOException {
        
        ServerSocket ss = new ServerSocket(30000);
        int i = 1;
        while(true) {
            
            Socket s = ss.accept();
            map.put(s,i++);
            System.out.println(s.toString()+"----"+i);
            new Thread(new ServerMultiThread(s)).start();
        }
    }
}
