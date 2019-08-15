package yy.demo.demo1.aop.currentProxy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import yy.demo.demo1.common.entity.TestTable;

/**
 * @author yinmb
 * @Date 2019/4/8 17:10:05
 */
@RestController
public class Test01 {
    @Autowired
    GreetingServiceImpl greetingService;

    @RequestMapping(value = "/hello", method = RequestMethod.POST)
    @ResponseBody
    public String returnString(@RequestBody TestTable testTable) {
        System.out.println(testTable.getScore());
        greetingService.sayMessage("xiaoming ");
        return "hello return string 这是中文";
    }
}
