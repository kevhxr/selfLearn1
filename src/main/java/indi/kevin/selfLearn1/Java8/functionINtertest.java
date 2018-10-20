package indi.kevin.selfLearn1.Java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.*;

public class functionINtertest {

    public static void main(String[] args){
        donation(100,(money)-> System.out.println("I donate "+money));

        System.out.println();
        List<Integer> list = supply(4,() -> (int)(Math.random()*100));
        list.forEach(System.out::println);

        System.out.println();
        Integer value = convert("28", x -> Integer.parseInt(x));
        System.out.println(value);

        System.out.println();
        List<String> fruit = Arrays.asList("banana", "melon", "apple", "dragon fruit", "peach");
        List<String> newFruit = filter(fruit, (f) -> f.length() >= 7);
        System.out.println(newFruit);

        //25
        System.out.println();
        System.out.println(computeBi(2, 3, (v1, v2) -> v1 + v2, v1 -> v1 * v1));

        //6
        System.out.println();
        System.out.println(composeFunc(2,(v)->v+2, (v)->v*v));
    }

    //.accept do output (void)
    public static void donation(Integer money, Consumer<Integer> consumer){
        consumer.accept(money);
    }

    //.get return the calculated result (T)
    public static List<Integer> supply(Integer num, Supplier<Integer> supplier){
        List<Integer> resultList = new ArrayList<Integer>()   ;
        for(int x=0;x<num;x++)
            resultList.add(supplier.get());
        return resultList ;
    }

    //.apply run with passed val (apply(T))
    public static Integer convert(String str, Function<String, Integer> function) {
        return function.apply(str);
    }

    //.test return boolean (Boolean)
    public static List<String> filter(List<String> fruit, Predicate<String> predicate){
        List<String> f = new ArrayList<>();
        for (String s : fruit) {
            if(predicate.test(s)){
                f.add(s);
            }
        }
        return f;
    }



    public static int computeBi(int a, int b, BiFunction<Integer, Integer, Integer> biFunction, Function<Integer, Integer> function) {
        return biFunction.andThen(function).apply(a, b);
    }

    public static int composeFunc(int a, Function<Integer,Integer> function,Function<Integer,Integer> before){
        return  function.compose(before).apply(a);
    }
}
