package indi.kevin.selfLearn1.Transaction.Service;

import indi.kevin.selfLearn1.Transaction.DAO.AccountDAO;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;


public class AccountServiceImpl implements AccountService {

    public void setAccountDAO(AccountDAO accountDAO) {
        this.accountDAO = accountDAO;
    }

    private AccountDAO accountDAO;

    public void setTransactionTemplate(TransactionTemplate transactionTemplate) {
        this.transactionTemplate = transactionTemplate;
    }

    private TransactionTemplate transactionTemplate;

    @Override
    public void transfer(final String payer,final String payee,final Integer money) {
        transactionTemplate.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus transactionStatus) {
                accountDAO.out(payer,money);
              //  int i= 1/0;
                accountDAO.in(payee,money);
            }
        });
    }
}
