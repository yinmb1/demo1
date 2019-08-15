package yy.demo.demo1.exception.web;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import yy.demo.demo1.exception.ResultException;
import yy.demo.demo1.exception.entity.Result;
import yy.demo.demo1.exception.enums.ResultEmun;
import yy.demo.demo1.json.dto.User;
import yy.demo.demo1.mybaits.entity.OutBoundApply;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author yinmb
 * @Date 2019/4/17 17:18:35
 */
@Controller
@RequestMapping("/user")
public class ExceptionController {

    @ResponseBody
    @RequestMapping(value = "/list1")
    public Result jumpJsp() {
        Map<String,Object> map = new HashMap<>();
        map.put("userName","tom");
        map.put("age",11);
        map.put("asfsaf","asfdasf");
        List<User> users = new ArrayList<>();
        //users.add(null);
        User user = JSON.parseObject(JSON.toJSONString(map),User.class);
        //System.out.println(user.getAge());
        users.add(user);
        User user2 = new User();
        user2.setAge(12);
        users.add(user2);
        users.add(null);

        users.forEach(user1 -> {
            try {
                System.out.println(user1.getAge());
            }catch (Exception e){
                throw new   ResultException(ResultEmun.RESP_ERROR);
            }

        });

        //得到分页的结果对象
        //<OutBoundApply> personPageInfo = new PageInfo<>(personList);
        //得到分页中的person条目对象
        //List<OutBoundApply> pageList = personPageInfo.getList();
        //将结果存入map进行传送
        // List<OutBoundApply> personList1 = outBoundApplyService.getbyapplySerialNo("2353");
        return null;
    }
}
