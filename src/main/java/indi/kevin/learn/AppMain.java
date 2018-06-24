package indi.kevin.learn;

import java.util.Optional;

public class AppMain {

    public static void main(String[] args){
        System.out.println("first App start");
        String nullAbleStr = "nullAble String";
        Optional<String> myStr = Optional.ofNullable(nullAbleStr);
        System.out.println(myStr.get());
    }

}
