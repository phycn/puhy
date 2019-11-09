package cn.puhy.netty.http;

import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.*;

public class HttpRequestHandler extends SimpleChannelInboundHandler<FullHttpRequest> {

    protected void channelRead0(ChannelHandlerContext ctx, FullHttpRequest request) throws Exception {
        String uri = request.uri();
        System.out.println("uri: " + uri);
        System.out.println("version: " + request.protocolVersion());

        FullHttpResponse response = new DefaultFullHttpResponse(HttpVersion.HTTP_1_1
                , HttpResponseStatus.OK);
        ctx.writeAndFlush(response).addListener(ChannelFutureListener.CLOSE);
    }
}
