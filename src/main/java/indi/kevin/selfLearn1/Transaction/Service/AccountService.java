package indi.kevin.selfLearn1.Transaction.Service;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public interface AccountService {

    public void transfer(String payer,String payee,Integer money);
}
