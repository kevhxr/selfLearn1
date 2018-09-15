package indi.kevin.selfLearn1.Transaction.Service;

import indi.kevin.selfLearn1.Transaction.DAO.AccountDAO;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
public class AccountServiceImplBasic implements AccountService {

    public void setAccountDAO(AccountDAO accountDAO) {
        this.accountDAO = accountDAO;
    }

    private AccountDAO accountDAO;

    @Override
    /*@Transactional*/
    public void transfer(final String payer,final String payee,final Integer money) {
            accountDAO.out(payer,money);
            int i= 1/0;
            accountDAO.in(payee,money);
    }
}
