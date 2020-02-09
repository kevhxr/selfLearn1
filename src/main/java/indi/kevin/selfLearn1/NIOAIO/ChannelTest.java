package indi.kevin.selfLearn1.NIOAIO;

import org.junit.Test;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicStampedReference;

public class ChannelTest {
    private static AtomicStampedReference atomicStampedReference = new AtomicStampedReference(100, 1);
    int stamp = atomicStampedReference.getStamp();

    @Test
    public void testOpenDirect() throws IOException {

        FileChannel inChannel = null;
        FileChannel outChannel = null;

        try {
            inChannel = FileChannel.open(Paths.get("e:/", "1.jpg"), StandardOpenOption.READ);
            outChannel = FileChannel.open(Paths.get("e:/", "2.jpg"),
                    StandardOpenOption.WRITE, StandardOpenOption.READ, StandardOpenOption.CREATE);
            MappedByteBuffer inMap = inChannel.map(FileChannel.MapMode.READ_ONLY, 0, inChannel.size());
            MappedByteBuffer outMap = outChannel.map(FileChannel.MapMode.READ_WRITE, 0, inChannel.size());
            byte[] dst = new byte[inMap.limit()];
            outMap.put(dst);
            inMap.get(dst);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            inChannel.close();
            outChannel.close();
        }
    }


    @Test
    public void testTransferTo() throws IOException {
        FileChannel inChannel = FileChannel.open(Paths.get("e:/", "1.jpg"), StandardOpenOption.READ);
        FileChannel outChannel = FileChannel.open(Paths.get("e:/", "2.jpg"), StandardOpenOption.READ,
                StandardOpenOption.CREATE, StandardOpenOption.WRITE);

        inChannel.transferTo(0, inChannel.size(), outChannel);
        //outChannel.transferFrom(inChannel,0,inChannel.size());
        inChannel.close();
        outChannel.close();
    }

    @Test
    public void testIndirectBuffer() throws Exception {
        FileInputStream inputStream = new FileInputStream(Paths.get("e:/", "1.jpg").toFile());
        FileOutputStream outputStream = new FileOutputStream(Paths.get("e:/", "2.jpg").toFile());

        FileChannel inChannel = inputStream.getChannel();
        FileChannel outChannel = outputStream.getChannel();

        ByteBuffer buff = ByteBuffer.allocate(1024);

        while (inChannel.read(buff) != -1) {
            buff.flip();
            outChannel.write(buff);
            buff.clear();
        }

        outChannel.close();
        inChannel.close();
        inputStream.close();
        outputStream.close();
    }

    @Test
    public void testDivergeAndConverge() throws IOException {
        RandomAccessFile randomAccessFile = new RandomAccessFile(String.valueOf(Paths.get("e:/", "1.txt")), "rw");
        FileChannel channel = randomAccessFile.getChannel();

        ByteBuffer buff1 = ByteBuffer.allocate(1024);
        ByteBuffer buff2 = ByteBuffer.allocate(4096);

        ByteBuffer[] byteBuffers = {buff1, buff2};
        channel.read(byteBuffers);

        Arrays.stream(byteBuffers).forEach(bf->{
            bf.flip();
            System.out.println(new String(bf.array(), 0, bf.limit()));
            System.out.println("=====================");
        });

        RandomAccessFile inputFile = new RandomAccessFile(String.valueOf(Paths.get("e:/", "2.txt")), "rw");
        FileChannel inChannel = inputFile.getChannel();
        inChannel.write(byteBuffers);
    }


    @Test
    public void charsetDecodeTest() throws CharacterCodingException {
        Charset charset = Charset.forName("UTF-8");
        CharsetDecoder decoder = charset.newDecoder();
        CharsetEncoder encoder = charset.newEncoder();

        CharBuffer cbuff = CharBuffer.allocate(1024);

        cbuff.put("撒大声地");
        cbuff.flip();
        ByteBuffer bBuff = encoder.encode(cbuff);
        for (int i = 0; i <12 ; i++) {
            System.out.print(bBuff.get());
        }
        System.out.println("========");
        bBuff.flip();
        System.out.println(bBuff.position()+" "+bBuff.limit());
        CharBuffer cBuff2 = decoder.decode(bBuff);
        System.out.println(bBuff.position()+" "+bBuff.limit());
        System.out.println(cBuff2.toString());
    }
}
