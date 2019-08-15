package yy.demo.demo1.transaction.notransaction;

/**
 * @author yinmb
 * @Date 2019/5/27 13:47:51
 */
public interface AccountDao {
    /**
     * 汇款
     * @param outer 汇款人
     * @param money 汇款金额
     */
    public void out(String outer,int money);

    /**
     * 收款
     * @param inner 收款人
     * @param money 收款金额
     */
    public void in(String inner,int money);
}
