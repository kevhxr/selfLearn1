package indi.kevin.selfLearn1.NIOAIO.BasicTest;

import com.sun.xml.internal.messaging.saaj.util.ByteOutputStream;

import java.io.*;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;

public class UDPClient {

    public static void main(String[] args) throws IOException {
        System.out.println("client side start..");
        DatagramSocket client = new DatagramSocket(6666);

        /*String message = "hello world";
        byte[] datas = message.getBytes();
        */

        byte[] datas =prepareData();

        DatagramPacket packet = new DatagramPacket(datas,0,datas.length,new InetSocketAddress("localhost",8888));
        client.send(packet);
        client.close();

    }

    public static byte[] prepareData() throws IOException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        DataOutputStream daos = new DataOutputStream(baos);
        daos.writeUTF("im string");
        daos.write(11);
        daos.writeBoolean(false);
        daos.writeChar('a');
        daos.flush();
        byte[] data = baos.toByteArray();
        return data;
    }

    public static byte[] fileToByteArray(String path) throws IOException {
        File file = new File(path);
        byte[] bytes = new byte[(int) file.length()];
        FileInputStream fis = new FileInputStream(file);
        fis.read(bytes);
        return  bytes;
    }
}
