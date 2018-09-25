package indi.kevin.selfLearn1.NIOAIO;

import indi.kevin.selfLearn1.NIOAIO.ClientSide.BadClient;

import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import java.util.concurrent.*;

public class MainTest {

    public static void main(String[] args){
/*
        ThreadPoolExecutor executor = new ThreadPoolExecutor(2,4,15,TimeUnit.SECONDS, new LinkedBlockingDeque<>());
        executor.execute(new BadClient());
        executor.shutdown();
*/

       IntBuffer buf = IntBuffer.allocate(10);
        buf.put(1);
        buf.put(2);
        buf.put(3);
        System.out.println(buf);
        buf.flip();
        buf.put(1,23);


        PriorityBlockingQueue queue = new PriorityBlockingQueue();
        queue.add(new Comparable<String>() {
            @Override
            public int compareTo(String o) {
                return 0;
            }
        });
        System.out.println(buf.get(1)+" "+buf);

    }
}
