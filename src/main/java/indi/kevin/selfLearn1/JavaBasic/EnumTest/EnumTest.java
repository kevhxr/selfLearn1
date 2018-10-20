package indi.kevin.selfLearn1.JavaBasic.EnumTest;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class EnumTest {
    public static void main(String[] args){
        //直接引用
/*        Day day =Day.MONDAY;
        Day day2 =Day.TUESDAY;
        Class<?> clazz = day.getDeclaringClass();
        System.out.println("day class is:   "+clazz.getSimpleName());
        System.out.println("day name is:   "+day.name());
        System.out.println("day ordinal is:   "+day.ordinal());
        System.out.println("day to string is:   "+day.toString());
        System.out.println("day compare day2 is:   "+day.compareTo(day2));
        System.out.println("Day enum valueof is:   "+Day.valueOf("MONDAY"));
        System.out.println();
        Arrays.stream(Day.values()).forEach(s-> System.out.print(s+", "));

        System.out.println();
        Arrays.stream(Departments.values()).forEach(s-> System.out.println(s.getComponentName()+":"+s.getDepartName()));*/

        Map<String,Integer> map = new HashMap<>();
        if(map.get("name")==null){
            map.put("name",1);
        }
        int getv = map.get("name");
        System.out.println(getv);

    }
}
