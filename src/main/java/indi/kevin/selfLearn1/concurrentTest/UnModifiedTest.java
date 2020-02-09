package indi.kevin.selfLearn1.concurrentTest;

import com.google.common.collect.ImmutableList;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class UnModifiedTest {

    public static void main(String[] args) throws Exception {
/*
        String s = "s World";
        String sb = "sb World";
        String craxy = "craxy World";
        System.out.println("s = " + s);

        Field valueFieldOfString = String.class.getDeclaredField("value");
        valueFieldOfString.setAccessible(true);

        char[] value = (char[]) valueFieldOfString.get(s);
        char[] value1 = (char[]) valueFieldOfString.get(sb);
        value[5] = '_';
        System.out.println("s = " + s);
*/



        List<Integer> list = new ArrayList<Integer>();
        list.add(1);
        System.out.println(list);

        List unmodifiableList = Collections.unmodifiableList(list);
        ImmutableList immutableList = ImmutableList.copyOf(list);

        System.out.println(immutableList);
        list.add(2);
        immutableList = ImmutableList.copyOf(list);

        System.out.println(unmodifiableList);
        System.out.println(immutableList);
    }
}
