package indi.kevin.selfLearn1.Transaction.DAO;

public interface AccountDAO {
    public void out(String payer, Integer money);

    public void in(String payee, Integer money);
}
