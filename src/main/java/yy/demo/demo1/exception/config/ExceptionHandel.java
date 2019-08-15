package yy.demo.demo1.exception.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import yy.demo.demo1.exception.ResultException;
import yy.demo.demo1.exception.entity.Result;
import yy.demo.demo1.exception.utils.RestUtils;


/**
 * @author yinmb
 * @Date 2019/1/22 14:56:15
 */

@ControllerAdvice
@ResponseBody
@Slf4j
public class ExceptionHandel {


    @ExceptionHandler(ResultException.class)
    public Result doHandleUnknowException(ResultException e) {
        log.info(e + "未知异常");
        return RestUtils.error(e);
    }
}
