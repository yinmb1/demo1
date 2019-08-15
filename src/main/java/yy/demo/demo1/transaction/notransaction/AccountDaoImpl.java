package yy.demo.demo1.transaction.notransaction;

import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Service;

/**
 * @author yinmb
 * @Date 2019/5/27 13:48:43
 */
public class AccountDaoImpl extends JdbcDaoSupport implements AccountDao {

    /**
     * 根据用户名减少账户金额
     */
    @Override
    public void out(String outer, int score) {
        this.getJdbcTemplate().update("update test_table set score = score - ? where name = ?",score,outer);
    }

    /**
     * 根据用户名增加账户金额
     */
    @Override
    public void in(String inner, int score) {
        this.getJdbcTemplate().update("update test_table set score = score + ? where name = ?",score,inner);
    }

}