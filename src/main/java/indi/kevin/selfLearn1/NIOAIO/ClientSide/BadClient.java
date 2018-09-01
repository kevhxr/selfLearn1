package indi.kevin.selfLearn1.NIOAIO.ClientSide;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.LockSupport;


public class BadClient implements Runnable{
    private static ExecutorService executorService = Executors.newCachedThreadPool();
    private final static int sleep_time = 1000*1000*1000;
    @Override
    public void run() {
        Socket client = new Socket();
        try {
            client.connect(new InetSocketAddress("localhost",8080));
            PrintWriter writer = new PrintWriter(client.getOutputStream(),true);
            writer.print("H");
            LockSupport.parkNanos(sleep_time);
            writer.print("e");
            LockSupport.parkNanos(sleep_time);
            writer.print("l");
            LockSupport.parkNanos(sleep_time);
            writer.print("l");
            LockSupport.parkNanos(sleep_time);
            writer.print("o");
            LockSupport.parkNanos(sleep_time);
            writer.println();
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
