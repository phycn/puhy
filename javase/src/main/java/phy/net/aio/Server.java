package phy.net.aio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.AsynchronousChannelGroup;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author puhongyu
 * 2018/6/2 08:59
 */
public class Server {
    public static void main(String[] args) throws IOException {
        new Server().init();
    }

    private void init() throws IOException {

        ExecutorService executorService = Executors.newFixedThreadPool(5);
        AsynchronousChannelGroup acg = AsynchronousChannelGroup.withThreadPool(executorService);
        AsynchronousServerSocketChannel assc = AsynchronousServerSocketChannel.open(acg);
        assc.bind(new InetSocketAddress(25339));
        assc.accept(null, new AccpetHandler(assc));
        while (true) {

        }
    }
}
