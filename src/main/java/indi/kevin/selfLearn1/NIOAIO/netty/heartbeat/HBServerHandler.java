package indi.kevin.selfLearn1.NIOAIO.netty.heartbeat;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.handler.timeout.IdleStateEvent;

public class HBServerHandler extends ChannelInboundHandlerAdapter {

    @Override
    public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {
        if (evt instanceof IdleStateEvent) {
            IdleStateEvent event = (IdleStateEvent) evt;
            String eventType = null;
            switch (event.state()) {
                case WRITER_IDLE:
                    eventType = "write idle";
                    break;
                case READER_IDLE:
                    eventType = "read idle";
                    break;
                case ALL_IDLE:
                    eventType = "read&&write idle";
                    break;
            }
            System.out.println(ctx.channel().remoteAddress() + " event: " + eventType);
            ctx.channel().close();
        }
    }
}
