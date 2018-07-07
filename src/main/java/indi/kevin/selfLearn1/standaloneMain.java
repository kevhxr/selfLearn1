package indi.kevin.selfLearn1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class standaloneMain {

    public static ApplicationContext applicationContext;

    public static void main(String[] args){
        ApplicationContext classPathXmlApplicationContext =
                new FileSystemXmlApplicationContext("src/main/WEB-INF/common.xml");
        applicationContext = classPathXmlApplicationContext;

    }
}
