package yy.demo.demo1.transaction.transactiontemplate;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import yy.demo.demo1.transaction.notransaction.AccountService;

/**
 * @author yinmb
 * @Date 2019/5/27 14:38:15
 */
public class TransactionTemplateTest {
    @Test
    public void testNoTransaction(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext1.xml");
        AccountService account = (AccountService) context.getBean("accountService");
        //Tom 向 Marry 转账1000
        account.transfer("Tom", "Jack", 10);
    }
}
