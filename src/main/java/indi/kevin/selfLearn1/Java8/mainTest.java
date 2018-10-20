package indi.kevin.selfLearn1.Java8;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class mainTest {

    public static void main(String[] args){
        Sample sample = new SampleImpl();
        System.out.println(sample.getSampleName()
                + " "
                +sample.getSampleId()
                + " "
                +sample.getNumber());
        Sample.printName();

        long longNum = 1;
        System.out.println(longNum>1);

        IntStream stream = IntStream.of(1,2,3);
        System.out.println(stream.filter(a->(a>1)).count());
        stream = IntStream.range(1,5);
        stream.forEach(a-> System.out.print(a+","));

        System.out.println();
        stream = IntStream.rangeClosed(1,5);
        stream.forEach(a-> System.out.print(a+","));

        System.out.println();
        Stream<List<Integer>> inputStream = Stream.of(
                Arrays.asList(1),
                Arrays.asList(2, 3),
                Arrays.asList(4, 5, 6)
        );
        Stream<Integer> outputStream = inputStream.
                flatMap((childList) -> childList.stream());
        outputStream.forEach(a-> System.out.print(a+"-"));

        System.out.println();
        String concat = Stream.of("A", "B", "C", "D").reduce("g", String::concat);
        System.out.println(concat);
        int sumValue = Stream.of(1, 2, 3, 4).reduce(2, (a, b) -> a+b);
        System.out.println(sumValue);


    }

}
