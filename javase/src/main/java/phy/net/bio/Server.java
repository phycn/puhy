package phy.net.bio;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author puhongyu
 * 2018/6/1 20:05
 */
public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(25339);
        System.out.println("服务器启动成功");
        while (true) {
            Socket socket = serverSocket.accept();
            Thread handler = new Thread(new ServerHandler(socket));
            handler.start();
        }
    }
}
