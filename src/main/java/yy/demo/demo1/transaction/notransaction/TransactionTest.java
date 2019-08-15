package yy.demo.demo1.transaction.notransaction;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


/**
 * @author yinmb
 * @Date 2019/5/27 13:55:39
 */
public class TransactionTest {
    @Test
    public void testNoTransaction(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        AccountService account = (AccountService) context.getBean("accountService");
        //Tom 向 Marry 转账1000
        account.transfer("Tom", "Jack", 10);
    }
}
