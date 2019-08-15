package yy.demo.demo1.spring.applicationcontext;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.test.context.junit4.SpringRunner;
import yy.demo.demo1.spring.applicationcontext.service.AbstractFoodService;

/**
 * @author yinmb
 * @Date 2019/6/20 15:35:18
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationContextHolderTest {

    @Autowired
    AbstractFoodService abstractFoodService;

    @Test
    public void applicationContextTest() {
        //test 环境会报错 No qualifying bean of type
        AbstractFoodService service = abstractFoodService.getServiceByTypeInMap("Bread");
        service.getName();
    }

    @Test
    public void applicationContextTest02() {
        System.out.println("kaishidiaoyong");
        AbstractFoodService service = abstractFoodService.getServiceByTypeInMap("AppleBread");
        service.getName();
    }

    @Test
    public void applicationContextTest03() {
        AbstractFoodService service = abstractFoodService.getServiceByTypeInMap("Meat");
        service.getName();
    }
}