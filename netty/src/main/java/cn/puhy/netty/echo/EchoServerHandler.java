package cn.puhy.netty.echo;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.CharsetUtil;

/**
 * ChannelInboundHandlerAdapter响应入站事件
 */
@ChannelHandler.Sharable    // 标识一个ChannelHandler可以被多个Channel安全地共享
public class EchoServerHandler extends ChannelInboundHandlerAdapter {

    // 对于每个传入的消息都要调用
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        ByteBuf in = (ByteBuf) msg;
        System.out.println("服务端收到的消息: " + in.toString(CharsetUtil.UTF_8));
        ByteBuf out = Unpooled.copiedBuffer("phy haha", CharsetUtil.UTF_8);
        ctx.write(out);
    }

    // 通知ChannelInboundHandler最后一次对channelRead()的调用是当前批量读取中的最后一条消息
    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        // 将未决消息冲刷到远程节点，并关闭Channel
        ctx.writeAndFlush(Unpooled.EMPTY_BUFFER).addListener(ChannelFutureListener.CLOSE);
    }
}
