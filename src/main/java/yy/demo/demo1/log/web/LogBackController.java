package yy.demo.demo1.log.web;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import yy.demo.demo1.log.annotation.NoControllerLog;

/**
 * @author yinmb
 * @Date 2019/7/9 09:48:19
 */
@Slf4j
@RestController
@RequestMapping("/logBack")
public class LogBackController {
    @NoControllerLog
    @RequestMapping("/test01")
    public void applicationContextTest(@RequestBody JSONObject jsonObject) {
        for (int i = 0;i < 5000;i++){
            log.info("日志测试：{}",i);
        }
    }
}
