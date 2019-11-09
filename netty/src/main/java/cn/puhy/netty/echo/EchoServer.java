package cn.puhy.netty.echo;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

public class EchoServer {

    public static void main(String[] args) throws InterruptedException {
        final EchoServerHandler echoServerHandler = new EchoServerHandler();
        EventLoopGroup group = new NioEventLoopGroup();
        ServerBootstrap bootstrap = new ServerBootstrap();
        try {
            bootstrap.group(group)
                    .channel(NioServerSocketChannel.class)      // 指定NIO
                    .localAddress(9999)                         // 端口
                    // 当一个新的连接被接受时，一个新的子Channel将会被创建，
                    // ChannelInitializer将会把EchoServerHandler的实例添加到该Channel的
                    // ChannelPipeline中
                    .childHandler(new ChannelInitializer<SocketChannel>() {
                        protected void initChannel(SocketChannel ch) throws Exception {
                            ch.pipeline().addLast(echoServerHandler);
                        }
                    });
            // 绑定服务器，调用sync()阻塞直到绑定完成
            ChannelFuture channelFuture = bootstrap.bind().sync();
            // 阻塞main线程，不然会直接退出
            channelFuture.channel().closeFuture().sync();
        } finally {
            // 释放资源
            group.shutdownGracefully().sync();
        }
    }
}
