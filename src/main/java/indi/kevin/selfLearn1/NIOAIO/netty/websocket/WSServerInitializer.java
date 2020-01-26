package indi.kevin.selfLearn1.NIOAIO.netty.websocket;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpServerCodec;
import io.netty.handler.codec.http.websocketx.WebSocketServerProtocolHandler;
import io.netty.handler.stream.ChunkedWriteHandler;

public class WSServerInitializer extends ChannelInitializer<SocketChannel> {
    @Override
    protected void initChannel(SocketChannel ch) throws Exception {
        ChannelPipeline pipeline = ch.pipeline();
        pipeline.addLast("", new HttpServerCodec());
        pipeline.addLast(new ChunkedWriteHandler());
        /**
         * HttpObjectAggregator
         * used to combine small block into large chunk of data
         * original each time channelread0 only read 1 block of it ...
         */
        pipeline.addLast(new HttpObjectAggregator(8192));
        /**
         * "/ws111"
         * ws://localhost:9999/ws111
         */
        pipeline.addLast(new WebSocketServerProtocolHandler("/ws"));
        pipeline.addLast(new TextWSFrameHandler());
    }
}
