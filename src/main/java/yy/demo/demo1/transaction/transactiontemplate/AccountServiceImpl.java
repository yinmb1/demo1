package yy.demo.demo1.transaction.transactiontemplate;

import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;
import yy.demo.demo1.transaction.notransaction.AccountDao;
import yy.demo.demo1.transaction.notransaction.AccountService;

/**
 * 上面转账的两步操作中间发生了异常，但是第一步依然在数据库中进行了增加操作。
 * 实际应用中不会允许这样的情况发生，所以我们这里用事务来进行管理。
 *
 *　Dao 层不变，我们在 Service 层注入 TransactionTemplate 模板，
 * 因为是用模板来管理事务，所以模板需要注入事务管理器  DataSourceTransactionManager 。
 * 而事务管理器说到底还是用底层的JDBC在管理，所以我们需要在事务管理器中注入 DataSource。
 * 这几个步骤分别如下：
 * @author yinmb
 * @Date 2019/5/27 14:32:24
 */
public class AccountServiceImpl implements AccountService {

    private AccountDao accountDao;
    private TransactionTemplate transactionTemplate;

    public void setTransactionTemplate(TransactionTemplate transactionTemplate) {
        this.transactionTemplate = transactionTemplate;
    }
    public void setAccountDao(AccountDao accountDao) {
        this.accountDao = accountDao;
    }
    @Override
    public void transfer(final String outer,final String inner,final int money) {
        transactionTemplate.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus arg0) {
                accountDao.out(outer, money);
                int i = 1/0;
                accountDao.in(inner, money);
            }
        });
    }

}