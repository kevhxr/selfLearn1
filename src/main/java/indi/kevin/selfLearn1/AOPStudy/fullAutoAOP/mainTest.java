package indi.kevin.selfLearn1.AOPStudy.fullAutoAOP;

import indi.kevin.selfLearn1.AOPStudy.interfaces.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class mainTest {

    public static void main(String[] args){
/*        ApplicationContext classPathXmlApplicationContext =
                new FileSystemXmlApplicationContext("src/main/WEB-INF/AOP/aopBean.xml");*/
        ApplicationContext classPathXmlApplicationContext =
                new FileSystemXmlApplicationContext("src/main/WEB-INF/AOP/aopBeanTwo.xml");
        ApplicationContext applicationContext = classPathXmlApplicationContext;

       //get proxy class
/*       UserService userService = (UserService) applicationContext.getBean("userServiceId");
       userService.addUser();
       userService.updateUser("kevin");
       userService.deleteUser();*/

        System.out.println("========================================================================");

        UserService userService1 = (UserService) applicationContext.getBean("userServiceAnoId");
        userService1.addUser();
        System.out.println("========================================================================");
        userService1.updateUser("kevin");
        System.out.println("========================================================================");
        userService1.deleteUser();
    }
}
