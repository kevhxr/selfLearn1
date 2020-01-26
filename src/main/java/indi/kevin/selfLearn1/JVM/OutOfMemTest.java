package indi.kevin.selfLearn1.JVM;

import java.util.ArrayList;

/**
 * -Xms5m -Xmx5m -XX:+HeapDumpOnOutOfMemoryError -XX:HeapDumpPath=E:\testrepo\test.hprof
 */
public class OutOfMemTest {
    public static void main(String[] args) {
        ArrayList<Object> list = new ArrayList<>();
        for (;;){
            list.add(new OutOfMemTest());
        }
    }
}
