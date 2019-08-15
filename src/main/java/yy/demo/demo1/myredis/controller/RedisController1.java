package yy.demo.demo1.myredis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.*;

/**
 * @author yinmb
 * @Date 2019/3/20 16:12:43
 */
@RestController
public class RedisController1 {
    @Autowired
    RedisTemplate redisTemplate;

    @Autowired
    StringRedisTemplate stringRedisTemplate;

    @RequestMapping(value = "/getRedisTemplate",method = RequestMethod.POST)
    @ResponseBody
    public void getRedisTemplate(){

    }
}
