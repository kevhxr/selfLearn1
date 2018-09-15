package indi.kevin.selfLearn1.NIOAIO.BasicTest;

import org.junit.Test;
import org.omg.SendingContext.RunTime;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.InetAddress;
import java.net.URL;
import java.net.UnknownHostException;

public class Inet {

    public static void main(String[] args) throws UnknownHostException {
        InetAddress inetAddress = InetAddress.getLocalHost();
        System.out.println(inetAddress.getHostAddress());
        System.out.println(inetAddress.getHostName());
        System.out.println(Runtime.getRuntime().availableProcessors());
        inetAddress = InetAddress.getByName("www.google.com");
        System.out.println(inetAddress.getHostAddress());
        System.out.println(inetAddress.getHostName());
    }

    @Test
    public void spiderTest() throws Exception{
        URL url = new URL("https://baidu.com");
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        connection.setRequestProperty("User-Agent","Mozilla/5.0 (Windows NT 6.1; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/69.0.3497.81 Safari/537.36");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(connection.getInputStream(),"UTF-8"));
        String message = null;
        while(null!=(message=bufferedReader.readLine())){
            System.out.println(message);
        }
    }
}
