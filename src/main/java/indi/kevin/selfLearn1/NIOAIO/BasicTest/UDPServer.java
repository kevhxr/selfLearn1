package indi.kevin.selfLearn1.NIOAIO.BasicTest;

import java.io.*;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.util.ArrayList;
import java.util.List;

public class UDPServer {

    public static void main(String[] args) throws IOException {
        System.out.println("server start..");
        DatagramSocket serverSocet = new DatagramSocket(8888);
        byte[] container = new byte[1024];

        List<? extends Object> a = new ArrayList<String>();
        DatagramPacket datagramPacket = new DatagramPacket(container,0,container.length);
        serverSocet.receive(datagramPacket);
        byte[] datas = datagramPacket.getData();


        //System.out.println(new String(data,0,data.length));
        handleReceivedData(datas);
        serverSocet.close();
    }


    public static byte[] handleReceivedData(byte[] data) throws IOException {
        BufferedInputStream baos = new BufferedInputStream(new ByteArrayInputStream(data));
        DataInputStream daos = new DataInputStream(baos);
        String msg = daos.readUTF();
        int i = daos.read();
        boolean bool = daos.readBoolean();
        char ch = daos.readChar();
        System.out.println(msg + " "+i+" "+bool+" "+ch);
        return data;
    }
}
