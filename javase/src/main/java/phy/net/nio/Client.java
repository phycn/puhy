package phy.net.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.util.Scanner;

/**
 * @author puhongyu
 * 2018/6/1 21:34
 */
public class Client {

    private static Charset charset = Charset.forName("UTF-8");

    public static void main(String[] args) throws IOException {
        Selector selector = Selector.open();
        InetSocketAddress inetSocketAddress = new InetSocketAddress("localhost", 25339);
        //连接到指定主机的SocketChannel
        SocketChannel socketChannel = SocketChannel.open(inetSocketAddress);
        //非阻塞
        socketChannel.configureBlocking(false);
        //注册到Selector
        socketChannel.register(selector, SelectionKey.OP_READ);

        new Thread(new ClientHandler(selector)).start();

        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) {
            String line = in.nextLine();
            socketChannel.write(charset.encode(line));
        }
    }
}
