package yy.demo.demo1.log.advice;


import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.MethodParameter;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.RequestBodyAdvice;

import java.io.IOException;
import java.lang.reflect.Method;
import java.lang.reflect.Type;

/**
 * RequestBody 请求日志输出
 *
 * @author yinmb
 * @version 1.0.0
 * @date 2017/1/16
 */
@Slf4j
@ControllerAdvice
public class LogRequestBodyAdvice implements RequestBodyAdvice {
    public static final String reqStarttime =new String();



    @Override
    public boolean supports(MethodParameter methodParameter, Type type, Class<? extends HttpMessageConverter<?>> aClass) {
        return true;
    }

    @Override
    public Object handleEmptyBody(Object o, HttpInputMessage httpInputMessage, MethodParameter methodParameter, Type type, Class<? extends HttpMessageConverter<?>> aClass) {
        Method method=methodParameter.getMethod();
        System.out.println("66666666666666666666666666  handleEmptyBody"+method);
        log.info("{}.{}",method.getDeclaringClass().getSimpleName(),method.getName());
        return o;
    }

    @Override
    public HttpInputMessage beforeBodyRead(HttpInputMessage httpInputMessage, MethodParameter methodParameter, Type type, Class<? extends HttpMessageConverter<?>> aClass) throws IOException {
        System.out.println("8888888888888888888888888");
        return httpInputMessage;
    }

    @Override
    public Object afterBodyRead(Object o, HttpInputMessage httpInputMessage, MethodParameter methodParameter, Type type, Class<? extends HttpMessageConverter<?>> aClass) {
        Method method=methodParameter.getMethod();
        System.out.println("77777777777777777777777777  afterBodyRead"+method);
        log.info("{}.{}:{}",method.getDeclaringClass().getSimpleName(),method.getName(),JSON.toJSONString(o));
        return o;
    }
}
