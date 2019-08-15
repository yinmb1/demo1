package yy.demo.demo1.redis.controller;

import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import yy.demo.demo1.redis.JedisCacheClient;
import yy.demo.demo1.redis.bean.Dto;
import yy.demo.demo1.redis.bean.User;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * @author yinmb
 * @Date 2019/1/14 10:10:31
 */
@Controller
@RequestMapping("/user")
public class RedisController {
    @Autowired
    private JedisCacheClient jedisCacheClient;
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public String login(@RequestBody JSONObject jsonObject, HttpServletRequest request){

        Dto dto = new Dto();

        User user = login((String)jsonObject.get("username"), (String)jsonObject.get("password"));
        //登录成功生成token并保存token
        if (user != null) {
            String userAgent = request.getHeader("user-agent");
            String token =generateToken(userAgent, (String)jsonObject.get("username"));
            saveToken(token, user);

            dto.setIsLogin("true");
            dto.setToken(token);
            dto.setTokenCreatedTime(System.currentTimeMillis());
            dto.setTokenExpiryTime(System.currentTimeMillis() + 2*60*60*1000);

        } else {
            dto.setIsLogin("false");
        }
        return JSONObject.toJSONString(dto);
    }

    public User login(String username, String password){
        //假设数据库有个用户用户名为fengqing,密码为123456
        if ("fengqing".equals(username) && "123456".equals(password)){
            return new User(1, "fengqing", "123456");
        } else {
            return null;
        }
    }

    public String generateToken(String userAgent, String username){
        StringBuilder token = new StringBuilder();
        //加token:
        token.append("token:");
        //加时间
        token.append(new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date()) + "-");
        //加六位随机数111111-999999
        token.append(new Random().nextInt((999999 - 111111 + 1)) + 111111);
        System.out.println("token=>" + token.toString());
        return token.toString();
    }

    public void saveToken(String token, User user){
        //如果是PC，那么token保存两个小时；如果是MOBILE
        System.out.println(jedisCacheClient);
        jedisCacheClient.set(token, JSONObject.toJSONString(user));
        System.out.println(jedisCacheClient.get(token));

    }
}
