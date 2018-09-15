package indi.kevin.selfLearn1.Transaction;

import indi.kevin.selfLearn1.Transaction.Service.AccountService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class Main {

    public static void main(String[] args){
        ApplicationContext context = new FileSystemXmlApplicationContext("src/main/WEB-INF/transSpring.xml");
        System.out.println("========================================================================");
        //AccountService accountService = (AccountService) context.getBean("accountService");

       // AccountService accountService = (AccountService) context.getBean("accountServiceProxy");

        AccountService accountService = (AccountService) context.getBean("accountServiceBasic");
        accountService.transfer("kevin","chris",100);
    }
}
