package yy.demo.demo1.transaction.notransaction;

/**
 * @author yinmb
 * @Date 2019/5/27 13:53:34
 */
public interface AccountService {
    /**
     * 转账
     * @param outer 汇款人
     * @param inner 收款人
     * @param money 交易金额
     */
    public void transfer(String outer,String inner,int money);
}
