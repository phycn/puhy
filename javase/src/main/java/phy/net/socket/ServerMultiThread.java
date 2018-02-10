package phy.net.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

public class ServerMultiThread implements Runnable {

    private Socket s;
    private BufferedReader br;

    public ServerMultiThread(Socket s) throws IOException {

        this.s = s;
        br = new BufferedReader(new InputStreamReader(s.getInputStream()));
    }

    private ServerMultiThread() {
    }

    @Override
    public void run() {

        String msg = null;
        try {
            while ((msg = readFromClient()) != null) {
                int i = ServerMulti.map.get(s);
                ServerMulti.map.remove(s);
                for(Socket s : ServerMulti.map.keySet()) {
                    
                    PrintStream p = new PrintStream(s.getOutputStream());
                    p.println(msg);
                }
                ServerMulti.map.put(s, i);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }
    
    private String readFromClient() {
        try {
            return br.readLine();
        }
        catch(Exception e) {
            ServerMulti.map.remove(s);
        }
        return null;
    }
}
