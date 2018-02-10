package phy.net.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.SocketTimeoutException;

public class Client {

    public static void main(String[] args) throws IOException {
        
        
        try {
            Socket socket = new Socket("127.0.0.1", 30000);
            //socket.setSoTimeout(3000);
            //将socket对应的输入流包装成BufferedReader
            BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String line = br.readLine();
            while(line != null && !line.equals("")) {
                System.out.println("来自服务器的消息：" + line);
            }
            
        }
        catch(SocketTimeoutException e) {
            e.printStackTrace();
        }
        
        //br.close();
        //socket.close();
    }
}
