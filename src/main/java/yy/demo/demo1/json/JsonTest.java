package yy.demo.demo1.json;

import com.alibaba.fastjson.JSON;
import yy.demo.demo1.json.dto.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author yinmb
 * @Date 2019/4/17 16:53:39
 */
public class JsonTest {
    /**
     * 1.json 转换多转少 不回报错
     * 2.循环中报异常 会中断调程序
     *
     *
     *
     * @param args
     */
    public static void main(String[] args) {
        Map<String,Object> map = new HashMap<>();
        map.put("userName","tom");
        map.put("age",11);
        map.put("asfsaf","asfdasf");
        List<User> users = new ArrayList<>();
        users.add(null);
        User user = JSON.parseObject(JSON.toJSONString(map),User.class);
        //System.out.println(user.getAge());
        users.add(user);
        User user2 = new User();
        user2.setAge(12);
        users.add(user2);
        users.add(null);

        users.forEach(user1 -> {
            try {
                throw new Exception("nihaoma");
               // System.out.println(user1.getAge());

            }catch (Exception e){
                System.out.println(e.getMessage());

            }

        });
    }

}
