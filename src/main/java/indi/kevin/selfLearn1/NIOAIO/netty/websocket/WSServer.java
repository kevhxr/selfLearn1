package indi.kevin.selfLearn1.NIOAIO.netty.websocket;


import indi.kevin.selfLearn1.NIOAIO.netty.heartbeat.HBServerInitializer;
import indi.kevin.selfLearn1.NIOAIO.netty.heartbeat.HbServer;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.Log4jConfigurer;

import java.io.FileNotFoundException;

/**
 * WebSocket based on http proxy, part of HTML5
 * long connection
 * has its own header property to help server side to identify this request
 * needed to be upgraded from http to WebSocket proxy
 * spring, tomcat, netty all support WebSocket
 */

/**
 * 李嘉图等价
 */
public class WSServer {

    private static final Logger logger = LoggerFactory.getLogger(HbServer.class);

    static{
        try {
            Log4jConfigurer.initLogging("src/main/resources/log4j.properties");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws Exception {
        logger.info("websocket test");
        EventLoopGroup workerGroup = new NioEventLoopGroup();
        EventLoopGroup bossGroup = new NioEventLoopGroup();
        try{
            ServerBootstrap serverBootstrap = new ServerBootstrap();
            serverBootstrap.group(bossGroup,workerGroup).channel(NioServerSocketChannel.class)
                    .handler(new LoggingHandler(LogLevel.INFO))
                    .childHandler(new WSServerInitializer());
            ChannelFuture channelFuture = serverBootstrap.bind(8899).sync();
            channelFuture.channel().closeFuture().sync();
        }finally {
            bossGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
        }
    }
}
