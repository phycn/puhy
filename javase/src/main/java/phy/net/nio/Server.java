package phy.net.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;

/**
 * @author puhongyu
 * 2018/6/1 20:51
 */
public class Server {

    private static Charset charset = Charset.forName("UTF-8");

    public static void main(String[] args) throws IOException {
        Selector selector = Selector.open();
        //打开一个未绑定的ServerSocketChannel实例
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        InetSocketAddress inetSocketAddress = new InetSocketAddress("localhost", 25339);
        //将ServerSocketChannel绑定到指定IP地址
        serverSocketChannel.bind(inetSocketAddress);
        //设置ServerSocket以非阻塞方式工作
        serverSocketChannel.configureBlocking(false);
        //将ServerSocketChannel注册到指定的Selector对象
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
        //监控所有注册的Channel
        while (selector.select() > 0) {
            //依次处理Selector上的每个已选择的SelectionKey
            for (SelectionKey sk : selector.selectedKeys()) {
                //删除正在处理的SelectionKey
                selector.selectedKeys().remove(sk);
                //连接请求
                if (sk.isAcceptable()) {
                    //调用accept接受连接，产生服务器端的SocketChannel
                    SocketChannel sc = serverSocketChannel.accept();
                    //非阻塞
                    sc.configureBlocking(false);
                    //也注册到selector
                    sc.register(selector, SelectionKey.OP_READ);
                    //将sk对应的Channel设置成准备接收其他请求
                    sk.interestOps(SelectionKey.OP_ACCEPT);
                } else if (sk.isReadable()) {   //数据读取
                    SocketChannel sc = (SocketChannel) sk.channel();
                    ByteBuffer buffer = ByteBuffer.allocate(1024);
                    StringBuilder content = new StringBuilder();
                    while (sc.read(buffer) > 0) {
                        buffer.flip();
                        content.append(charset.decode(buffer));
                    }
                    System.out.println("收到的消息：" + content.toString());
                    sc.write(charset.encode("1111"));
                    //准备下一次读取
                    sk.interestOps(SelectionKey.OP_READ);
                } else if (sk.isWritable()) {   //写数据

                }
            }
        }
    }
}
