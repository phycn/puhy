package phy.net.aio;

import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;
import java.nio.charset.Charset;

/**
 * @author puhongyu
 * 2018/6/2 09:03
 */
public class AccpetHandler implements CompletionHandler<AsynchronousSocketChannel, Object> {

    private Charset charset = Charset.forName("UTF-8");
    private AsynchronousServerSocketChannel assc;
    private ByteBuffer buffer = ByteBuffer.allocate(1024);

    public AccpetHandler(AsynchronousServerSocketChannel assc) {
        this.assc = assc;
    }

    @Override
    public void completed(AsynchronousSocketChannel asc, Object attachment) {
        //准备接收客户端的下一次连接
        assc.accept(null, this);
        asc.read(buffer, null, new CompletionHandler<Integer, Object>() {
            @Override
            public void completed(Integer result, Object attachment) {
                buffer.flip();
                String content = charset.decode(buffer).toString();
                System.out.println("收到来自客户端的消息：" + content);
                asc.write(charset.encode("phyphy"));
                buffer.clear();
                //准备读取下一次数据
                asc.read(buffer, null, this);
            }

            @Override
            public void failed(Throwable exc, Object attachment) {
                System.out.println("读取数据失败");
            }
        });
    }

    @Override
    public void failed(Throwable exc, Object attachment) {
        System.out.println("连接失败");
    }
}
