package yy.demo.demo1.base.retry;

import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.servlet.http.HttpServletRequest;

/**
 * @author yinmb
 * @Date 2019/5/23 09:37:37
 */
@Controller
@RequestMapping("/retry")
public class RetryController {
    @Autowired
    private RetryService retryService ;

    @RequestMapping(value = "/hello", method = RequestMethod.POST)
    @ResponseBody
    public String hello(@RequestBody JSONObject jsonObject, HttpServletRequest request){
        try {
            retryService.call();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
