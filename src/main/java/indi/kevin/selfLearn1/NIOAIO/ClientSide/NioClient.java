package indi.kevin.selfLearn1.NIOAIO.ClientSide;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.util.Scanner;

public class NioClient implements Runnable {
    public static void main(String[] args) {
        new Thread(new NioClient(9999)).start();
    }

    private ByteBuffer writeBuffer = ByteBuffer.allocate(1024);
    private ByteBuffer readBuffer = ByteBuffer.allocate(1024);
    private  SocketChannel clientChannel;
    public NioClient(int portNum) {
        startClient(portNum);
    }

    public void startClient(int portNum) {
        try {
            clientChannel = SocketChannel.open();
            clientChannel.connect(new InetSocketAddress(portNum));
            Scanner scanner = new Scanner(System.in);
            while (true) {
                System.out.print("write what you want to send to server:");
                String message = scanner.nextLine();
                if(message.equals("exit")){
                    break;
                }
                writeBuffer.clear();
                writeBuffer.put(message.getBytes("UTF-8"));
                writeBuffer.flip();
                clientChannel.write(writeBuffer);

                int readLength = clientChannel.read(readBuffer);
                if(readLength==-1){
                    break;
                }
                readBuffer.flip();
                byte[] bytes = new byte[readBuffer.remaining()];
                readBuffer.get(bytes);
                System.out.println("receive message from server:"+new String(bytes,"UTF-8"));
                readBuffer.clear();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                clientChannel.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

    }

    @Override
    public void run() {

    }
}
