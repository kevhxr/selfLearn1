package indi.kevin.selfLearn1.Transaction.DAO;

import org.springframework.jdbc.core.support.JdbcDaoSupport;

public class AccountDaoImpl extends JdbcDaoSupport implements AccountDAO {

    @Override
    public void out(String payer, Integer money) {
        this.getJdbcTemplate().update("update account set money = money - ? where username = ?",money,payer);
    }

    @Override
    public void in(String payee, Integer money) {
        this.getJdbcTemplate().update("update account set money = money + ? where username = ?",money,payee);

    }
}
