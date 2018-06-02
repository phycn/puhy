package phy.net.bio;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 * 读取服务端消息的线程
 *
 * @author puhongyu
 * 2018/6/1 20:32
 */
public class ClientHandler implements Runnable {

    private Socket socket;

    public ClientHandler(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        String response;
        try (BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {
            while ((response = br.readLine()) != null) {
                System.out.println("收到来自服务器的消息：" + response);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
