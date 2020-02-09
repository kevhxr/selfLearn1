package indi.kevin.selfLearn1.concurrentTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class VolatileTest {

    public static volatile int[] ints = new int[5];
    public static void main(String[] args) throws Exception {
        Object o = new Object();
        new Thread(() -> {
            //线程A
            try {
                TimeUnit.MILLISECONDS.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            ints[0] = 2;
        }).start();
        new Thread(() -> {            //线程B
            while (true) {
                if (ints[0] == 2) {
                    System.out.println("结束");
                    break;
                }
            }
        }).start();
    }

}
