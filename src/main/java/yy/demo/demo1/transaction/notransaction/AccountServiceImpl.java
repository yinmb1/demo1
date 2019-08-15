package yy.demo.demo1.transaction.notransaction;

import org.springframework.transaction.annotation.Transactional;

/**
 * @author yinmb
 * @Date 2019/5/27 13:54:05
 */
public class AccountServiceImpl implements AccountService{

    private AccountDao accountDao;

    public void setAccountDao(AccountDao accountDao) {
        this.accountDao = accountDao;
    }
    @Override
    public void transfer(String outer, String inner, int money) {
        accountDao.out(outer, money);
        int i= 10/0;
        accountDao.in(inner, money);
    }

}
