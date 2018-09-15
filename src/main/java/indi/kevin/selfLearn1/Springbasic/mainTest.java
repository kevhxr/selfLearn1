package indi.kevin.selfLearn1.Springbasic;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class mainTest {

    public static void main(String[] args){
        FileSystemXmlApplicationContext context = new FileSystemXmlApplicationContext("src/main/WEB-INF/BasicSpring/basic01.xml");
        UserService userService = (UserService) context.getBean("userService");
        System.out.println(userService);
        context.destroy();
    }
}
