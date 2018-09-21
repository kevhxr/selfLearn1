package indi.kevin.selfLearn1.JavaBasic;

import com.google.common.base.Stopwatch;
import org.junit.Test;

import java.io.*;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

public class CollectionTest {


    public static void main(String[] args){

/*        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("time is up");
            }
        },new Date(),2);*/

        try {
            FileInputStream fileInputStream = new FileInputStream(new File("E://temp_buffer.txt"));
            FileOutputStream fileOutputStream = new FileOutputStream(new File("E://temp_buffer2.txt"));
            FileChannel fch = fileInputStream.getChannel();
            FileChannel fchw = fileOutputStream.getChannel();

            ByteBuffer myBuf = ByteBuffer.allocate(1024);

            while(true){
                myBuf.clear();
                int i = fch.read(myBuf);
                if(i == -1){
                    break;
                }
                myBuf.flip();
                fchw.write(myBuf);
            }
            fch.close();
            fchw.close();

/*            Charset charset = Charset.forName("UTF-8");
            CharsetDecoder decoder = charset.newDecoder();
            CharBuffer charBuffer = decoder.decode(myBuf.asReadOnlyBuffer());
            System.out.println(charBuffer.toString());*/

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


/*        countArrayList(2000);
        System.out.println("===================================");
        countHashMap(2000);*/
    }


    public static void countHashMap(int num){
        HashMap<Integer,String> idNameMapd = new HashMap<Integer, String>();
        ConcurrentHashMap<Integer,String> idNameMap = new ConcurrentHashMap<Integer, String>();

        Stopwatch stopwatch = Stopwatch.createStarted();

        for (int i = 0; i <num ; i++) {
            idNameMap.put(i,"no"+i);
        }
        stopwatch.stop();
        System.out.println(stopwatch.elapsed(TimeUnit.NANOSECONDS));


        stopwatch.reset().start();
        idNameMap.get(num/2-20);
        Iterator iterator = idNameMap.entrySet().iterator();
        while (iterator.hasNext()){
            Map.Entry<Integer,String> entry = (Map.Entry<Integer, String>) iterator.next();
            //System.out.println(entry.getKey()+"==="+entry.getValue());
        }
        stopwatch.stop();
        System.out.println(stopwatch.elapsed(TimeUnit.NANOSECONDS));
    }

    public static void countArrayList(int num){
        ArrayList<String> arrayList = new ArrayList<>();
        String read;

        Stopwatch stopwatch = Stopwatch.createStarted();
        for (int i = 0; i <num ; i++) {
            arrayList.add(""+i);
        }
        stopwatch.stop();
        System.out.println(stopwatch.elapsed(TimeUnit.NANOSECONDS));

        stopwatch.reset().start();
        for (int i = 0; i <num ; i++) {
           read = arrayList.get(i);
        }
        stopwatch.stop();
        System.out.println(stopwatch.elapsed(TimeUnit.NANOSECONDS));
    }

    @Test
    public void doSort(){
        int[] array = {9,3,4,7,1};
        for (int i = array.length; i >0 ; i--) {
            for (int j = 0; j <i-1 ; j++) {
                if(array[j+1]<array[j]){
                    int tmp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = tmp;
                }
            }
        }
        System.out.println(Arrays.toString(array));
    }
}
