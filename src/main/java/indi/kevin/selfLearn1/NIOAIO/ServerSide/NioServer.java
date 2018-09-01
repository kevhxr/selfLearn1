package indi.kevin.selfLearn1.NIOAIO.ServerSide;

import indi.kevin.selfLearn1.NIOAIO.MessageHandler;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class NioServer {


    private ThreadPoolExecutor handlerPool;

    public NioServer(){
        this.handlerPool = new ThreadPoolExecutor(3,5,20,TimeUnit.SECONDS,new LinkedBlockingDeque<>());
        startServer();
    }

    public void startServer(){
        try {
            ServerSocket server = new ServerSocket(8080);
            while(true){
                Socket clientSocket = server.accept();
                System.out.println(clientSocket.getRemoteSocketAddress() + " connected!");
                handlerPool.execute(new MessageHandler(clientSocket));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
