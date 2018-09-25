package indi.kevin.selfLearn1.NIOAIO.ServerSide;

import indi.kevin.selfLearn1.NIOAIO.MessageHandler;

import java.io.*;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Scanner;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class NioServer implements Runnable{

    public static void main(String[] args){
        NioServer server = new NioServer(9999);
        new Thread(server).start();
    }

    private Selector selector;
    private ByteBuffer readBuffer = ByteBuffer.allocate(1024);
    private ByteBuffer writeBuffer = ByteBuffer.allocate(1024);

    public NioServer(int portNum){
        startServer(portNum);
    }

    public void startServer(int portNum){
        try {
            selector = Selector.open();
            System.out.println("server select opened.......");
            ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
            serverSocketChannel.configureBlocking(false);
            System.out.println("server socket channel opened.......");
            serverSocketChannel.bind(new InetSocketAddress(portNum));
            System.out.println("server socket channel port binded.......");
            serverSocketChannel.register(selector,SelectionKey.OP_ACCEPT);
            System.out.println("server registered OP_ACCEPT and start....");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        while(true){
            try{
                selector.select();
                Iterator<SelectionKey> keys = selector.selectedKeys().iterator();
                while(keys.hasNext()){
                    SelectionKey key = keys.next();
                    keys.remove();
                    if(key.isValid()) {
                        try {
                            if (key.isAcceptable()) {
                                accept(key);
                            } else if (key.isReadable()) {
                                read(key);
                            } else if (key.isWritable()) {
                                write(key);
                            }
                        }catch (CancelledKeyException e){
                            key.cancel();
                        }
                    }
                }
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }


    public void accept(SelectionKey key){
        try {
            ServerSocketChannel serverSocketChannel = (ServerSocketChannel) key.channel();
            SocketChannel socketChannel = serverSocketChannel.accept();
            socketChannel.configureBlocking(false);
            socketChannel.register(selector,SelectionKey.OP_READ);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void read(SelectionKey key){
        readBuffer.clear();
        SocketChannel channel = (SocketChannel) key.channel();
        try {
            int readLength = channel.read(readBuffer);
            if(readLength == -1){
                key.channel().close();
                key.cancel();
                return;
            }
            readBuffer.flip();
            byte[] bytes = new byte[readBuffer.remaining()];
            readBuffer.get(bytes);
            System.out.println("receive data from"+channel.getRemoteAddress()+" client: "+ new String(bytes,"UTF-8"));
            channel.register(selector,SelectionKey.OP_WRITE);
        } catch (IOException e) {
            e.printStackTrace();
            try {
                key.channel().close();
                key.cancel();
            } catch (IOException e1) {
                e1.printStackTrace();
            }

        }
    }

    public void write(SelectionKey key){
        writeBuffer.clear();
        SocketChannel channel = (SocketChannel) key.channel();
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.print("what message you want send to client?");
            String message = scanner.nextLine();
            writeBuffer.put(message.getBytes("UTF-8"));
            writeBuffer.flip();
            channel.write(writeBuffer);
            channel.register(selector,SelectionKey.OP_READ);
            System.out.println("ready to read again....");
        } catch (IOException e) {
            try {
                key.channel().close();
                key.cancel();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
            e.printStackTrace();
        }
    }
}
