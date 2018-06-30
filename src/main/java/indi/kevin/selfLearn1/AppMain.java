package indi.kevin.selfLearn1;

import indi.kevin.selfLearn1.concurrentTest.LiftOffThread;
import indi.kevin.selfLearn1.concurrentTest.ThreadGenerator;

import java.util.Optional;

public class AppMain {

    public static void main(String[] args){
        System.out.println("first App start");
        String nullAbleStr = "nullAble String";
        Optional<String> myStr = Optional.ofNullable(nullAbleStr);
        System.out.println(myStr.get());

        ThreadGenerator threadGenerator = new ThreadGenerator("indi.kevin.selfLearn1.concurrentTest.LiftOffThread");
        ThreadGenerator threadGenerator1 = new ThreadGenerator(new LiftOffThread(5));
        threadGenerator1.threadTest();
        threadGenerator.threadTest();
    }

}
