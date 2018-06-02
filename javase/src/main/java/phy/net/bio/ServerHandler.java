package phy.net.bio;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

/**
 * @author puhongyu
 * 2018/6/1 20:07
 */
public class ServerHandler implements Runnable {

    private Socket socket;

    public ServerHandler(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        String body;
        try (BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             PrintStream ps = new PrintStream(socket.getOutputStream())) {
            while ((body = br.readLine()) != null) {
                System.out.println("收到来自客户端的消息：" + body);
                ps.println("服务器收到消息了！");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
