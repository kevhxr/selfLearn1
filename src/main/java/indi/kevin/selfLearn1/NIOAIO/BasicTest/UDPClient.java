package indi.kevin.selfLearn1.NIOAIO.BasicTest;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;

public class UDPClient {

    public static void main(String[] args) throws IOException {
        System.out.println("client side start..");
        DatagramSocket client = new DatagramSocket(6666);

        String message = "hello world";
        byte[] datas = message.getBytes();
        DatagramPacket packet = new DatagramPacket(datas,0,datas.length,new InetSocketAddress("localhost",8888));
        client.send(packet);
        client.close();

    }
}
