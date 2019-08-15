package yy.demo.demo1.exception.utils;

import yy.demo.demo1.exception.entity.Result;
import yy.demo.demo1.exception.enums.ResultEmun;

/**
 * 处理工具
 * @author yinmb
 * @Date 2019/1/22 15:06:59
 */
public class RestUtils {
    public static Result error(Object date){
        return new Result(ResultEmun.RESP_ERROR,date);
    }
    public static Result error(ResultEmun resultEmun){
        return new Result(resultEmun);
    }
}
