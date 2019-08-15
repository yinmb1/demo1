package yy.demo.demo1.pagehelper.controller;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import yy.demo.demo1.exception.ResultException;
import yy.demo.demo1.exception.entity.Result;
import yy.demo.demo1.exception.enums.ResultEmun;
import yy.demo.demo1.mybaits.entity.OutBoundApply;
import yy.demo.demo1.mybaits.service.OutBoundApplyService;

import java.util.List;
import java.util.Map;

/**
 * @author yinmb
 * @Date 2019/1/18 15:17:51
 */
@Controller
@RequestMapping("/user")
public class PageControlller {
    @Autowired
    private OutBoundApplyService outBoundApplyService;

    /**
     * 查询所有的person内容
     * @return
     */

    @ResponseBody
    @RequestMapping(value = "/list")
    public Result jumpJsp() {
//        解析：
//
//    （1）PageHelper.startPage（pageNum ， pageSize），这个方法就是类似我们数据库操作的limit start ， count
//
//    （2）得到的对象PageInfo里面包含很多的字段信息，这个可以自己看源码，非常详细
//
//    （3）如果我们只想得到分页处理之后我们的实体对象的结果，那么就调用PageInfo对象的getList（）方法即可。
//
//    （4）这种配置使用的方式是最通用的方式，也就是对于环境搭建不同方式都可以利用这种使用方法。
//
//        问题：如果运行时出现，org.springframework.beans.factory.BeanCreationException: Error creating bean with name 'com.github.pagehelper.autoconfigure.PageHelperAutoConfiguration': 这个错误。
//
//        解决办法：这是由于分页插件pagehelper的版本和mybatis不兼容的原因，修改分页插件的版本即可
//
        PageHelper.startPage(45, 3);
        OutBoundApply personList = outBoundApplyService.getbyapplySerialNo(2);
        if (true){
            throw new ResultException(ResultEmun.RESP_ERROR);
        }
        //得到分页的结果对象
        //<OutBoundApply> personPageInfo = new PageInfo<>(personList);
        //得到分页中的person条目对象
        //List<OutBoundApply> pageList = personPageInfo.getList();
        //将结果存入map进行传送
       // List<OutBoundApply> personList1 = outBoundApplyService.getbyapplySerialNo("2353");
        return null;
    }


}
