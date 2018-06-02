package phy.net.nio;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;

/**
 * 读取服务端消息的线程
 *
 * @author puhongyu
 * 2018/6/1 21:45
 */
public class ClientHandler implements Runnable {

    private Selector selector;
    private static Charset charset = Charset.forName("UTF-8");

    public ClientHandler(Selector selector) {
        this.selector = selector;
    }

    @Override
    public void run() {
        try {
            while (selector.select() > 0) {
                for (SelectionKey sk : selector.selectedKeys()) {
                    selector.selectedKeys().remove(sk);
                    if (sk.isReadable()) {
                        SocketChannel sc = (SocketChannel) sk.channel();
                        ByteBuffer buffer = ByteBuffer.allocate(1024);
                        StringBuilder content = new StringBuilder();
                        while (sc.read(buffer) > 0) {
                            buffer.flip();
                            content.append(charset.decode(buffer));
                        }
                        System.out.println("收到来自服务器的消息：" + content.toString());
                        sk.interestOps(SelectionKey.OP_READ);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
