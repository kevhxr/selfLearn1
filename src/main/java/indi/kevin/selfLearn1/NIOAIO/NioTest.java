package indi.kevin.selfLearn1.NIOAIO;

import org.junit.Test;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class NioTest {

    @Test
    public void MyClient() throws IOException, InterruptedException {
        SocketChannel outChannel = SocketChannel.open(new InetSocketAddress("127.0.0.1",9888));
        FileChannel inChannel = FileChannel.open(Paths.get("e:/", "1.jpg"), StandardOpenOption.READ);
        ByteBuffer bBuff = ByteBuffer.allocate(1024);
        while(inChannel.read(bBuff)!=-1){
            bBuff.flip();
            outChannel.write(bBuff);
            bBuff.clear();
        }
        outChannel.shutdownOutput();
        System.out.println("try but failed sleep for retry");
        int len;
        len=outChannel.read(bBuff);
        while(len!=-1){
            bBuff.flip();
            System.out.println(new String(bBuff.array(),0,len));
            bBuff.clear();
            len=outChannel.read(bBuff);
        }
        inChannel.close();
        outChannel.close();
    }

    @Test
    public void MyServer() throws Exception{
        ServerSocketChannel ssChannel = ServerSocketChannel.open();
        FileChannel outChannel = FileChannel.open(Paths.get("e:/","2.jpg"),StandardOpenOption.WRITE,
                StandardOpenOption.CREATE);
        ssChannel.bind(new InetSocketAddress(9888));
        System.out.println("start to receive");
        SocketChannel inChannel = ssChannel.accept();
        System.out.println("received start process");
        ByteBuffer buffer = ByteBuffer.allocate(1024);

        while(inChannel.read(buffer)!=-1){
            buffer.flip();
            outChannel.write(buffer);
            buffer.clear();
        }

        buffer.put("Done thanks".getBytes());
        buffer.flip();
        Thread.sleep(5000);
        inChannel.write(buffer);
        inChannel.close();
        outChannel.close();
    }
}
