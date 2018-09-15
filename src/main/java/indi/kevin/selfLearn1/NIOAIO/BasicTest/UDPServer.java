package indi.kevin.selfLearn1.NIOAIO.BasicTest;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UDPServer {

    public static void main(String[] args) throws IOException {
        System.out.println("server start..");
        DatagramSocket serverSocet = new DatagramSocket(8888);
        byte[] container = new byte[1024];
        DatagramPacket datagramPacket = new DatagramPacket(container,0,container.length);
        serverSocet.receive(datagramPacket);
        byte[] data = datagramPacket.getData();
        System.out.println(new String(data,0,data.length));
        serverSocet.close();
    }
}
