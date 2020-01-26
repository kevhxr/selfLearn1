package indi.kevin.selfLearn1.NIOAIO.netty.chatroom;


import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

public class MyChatClientHandler extends SimpleChannelInboundHandler<String> {
    @Override
    protected void channelRead0(ChannelHandlerContext ch, String msg) throws Exception {
        System.out.println(msg);
    }
}
