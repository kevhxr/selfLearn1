package indi.kevin.selfLearn1.NIOAIO;

import com.google.common.base.Stopwatch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class MessageHandler implements Runnable {

    private Socket clientSocket;

    public MessageHandler(Socket clientSocket){
        this.clientSocket = clientSocket;
    }

    @Override
    public void run() {
        try {
            BufferedReader inputStream = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter outputStream = new PrintWriter(clientSocket.getOutputStream());

            String readLine;
            Stopwatch stopWatch = Stopwatch.createStarted();
            while((readLine=inputStream.readLine()) != null){
                outputStream.println(readLine);
            }
            stopWatch.stop();
            System.out.println("Read from client cost: "+stopWatch.elapsed());


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
