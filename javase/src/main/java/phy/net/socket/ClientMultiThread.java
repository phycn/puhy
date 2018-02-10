package phy.net.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class ClientMultiThread implements Runnable {

    private Socket s;
    private BufferedReader br;
    
    public ClientMultiThread(Socket s) throws IOException {
        
        this.s = s;
        br = new BufferedReader(new InputStreamReader(s.getInputStream()));
    }
    
    @Override
    public void run() {
        
        try {
            String content = null;
            while((content = br.readLine()) != null) {
               System.out.println(content); 
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }   
}
