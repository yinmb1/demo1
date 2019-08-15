package yy.demo.demo1.spring.aop;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import yy.demo.demo1.spring.aop.xml.IUserManagerService;

/**
 * @author yinmb
 * @Date 2019/5/22 15:16:02
 */

public class AopTest {

    public static void main(String[] args) throws Exception{

        ApplicationContext act =  new ClassPathXmlApplicationContext("application.xml");
        IUserManagerService userManager = (IUserManagerService)act.getBean("userManager");
        userManager.findUser();
        System.out.println("\n");
        userManager.addUser();
    }

    @Test
    public void annotateTest(){
        ApplicationContext act =  new ClassPathXmlApplicationContext("applicationannotate.xml");
        IUserManagerService userManager = (IUserManagerService)act.getBean("userManager");
        userManager.findUser();
        System.out.println("\n");
        userManager.addUser();
    }
}
