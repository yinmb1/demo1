package yy.demo.demo1.spring.applicationcontext.controller;

import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import yy.demo.demo1.elasticsearch.Employee;
import yy.demo.demo1.log.annotation.NoControllerLog;
import yy.demo.demo1.spring.applicationcontext.service.AbstractFoodService;

/**
 * @author yinmb
 * @Date 2019/6/20 17:40:51
 */
@RestController
@RequestMapping("/applicationContext")
public class ApplicationContextController {
    @Autowired
    AbstractFoodService abstractFoodService;

    @NoControllerLog
    @RequestMapping("/test01")
    public void applicationContextTest(@RequestBody JSONObject jsonObject) {
        //test 环境会报错 No qualifying bean of type
        AbstractFoodService service = abstractFoodService.getServiceByTypeInMap("Bread");
        service.getName();
    }

}
