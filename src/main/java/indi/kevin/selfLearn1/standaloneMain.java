package indi.kevin.selfLearn1;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class standaloneMain {

    public static ClassPathXmlApplicationContext applicationContext;

    public static void main(String[] args){
        ClassPathXmlApplicationContext classPathXmlApplicationContext =
                new ClassPathXmlApplicationContext("common.xml");
        applicationContext = classPathXmlApplicationContext;

    }
}
