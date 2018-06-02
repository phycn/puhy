package phy.net.bio;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

/**
 * @author puhongyu
 * 2018/6/1 20:17
 */
public class Client {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 25339);

        Thread handler = new Thread(new ClientHandler(socket));
        handler.start();

        Scanner in = new Scanner(System.in);
        System.out.print("消息：");
        PrintStream ps = new PrintStream(socket.getOutputStream());
        while (in.hasNextLine()) {
            String message = in.nextLine();
            ps.println(message);
        }
    }
}
