package indi.kevin.selfLearn1.AOPStudy.halfAutoProxy;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class mainTest {

    public static void main(String[] args){
        ApplicationContext classPathXmlApplicationContext =
                new FileSystemXmlApplicationContext("src/main/WEB-INF/proxyBean.xml");
       ApplicationContext applicationContext = classPathXmlApplicationContext;

       //get proxy class
       UserService userService = (UserService) applicationContext.getBean("proxyServiceId");
       userService.addUser();
       userService.updateUser();
       userService.deleteUser();
    }
}
