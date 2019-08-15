package yy.demo.demo1.mybaits.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import yy.demo.demo1.log.annotation.NoControllerLog;
import yy.demo.demo1.mybaits.entity.OutBoundApply;
import yy.demo.demo1.mybaits.service.OutBoundApplyService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author yinmb
 * @Date 2019/1/14 10:10:31
 */

@Controller
@RequestMapping("/user")
@Slf4j

public class MybatisController {
    @Autowired
    private OutBoundApplyService outBoundApplyService;

    @RequestMapping(value = "/mybatis", method = RequestMethod.POST)
    @ResponseBody
    public OutBoundApply login(@RequestBody JSONObject jsonObject){
        System.out.println(jsonObject.getString("applySerialNo"));
        OutBoundApply outBoundApply = outBoundApplyService.getbyapplySerialNo(jsonObject.getInteger("id"));


                if (outBoundApply!=null){
                    log.info(JSON.toJSONString(outBoundApply));
                }



        return outBoundApply;
    }

    @RequestMapping(value = "/updateOutBoundApply",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Integer> updateOutBountApply(@RequestBody OutBoundApply outBoundApply){
        Map<String,Integer> map =new HashMap<>();
        outBoundApplyService.updateOutBoundApply(outBoundApply);
        return map;
    }

    @RequestMapping(value = "/delectOutBoundApply",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Integer> delectOutBoundApply(@RequestBody OutBoundApply outBoundApply){
        Map<String,Integer> map =new HashMap<>();
        map.put("id",outBoundApplyService.deleteOutBoundApply(outBoundApply.getId()));
        return map;
    }
}
