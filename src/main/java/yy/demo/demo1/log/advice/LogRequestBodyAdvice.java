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

    /**
     * 该方法用于判断当前请求，是否要执行beforeBodyRead方法
     * @param methodParameter handler方法的参数对象
     * @param type handler方法的参数类型
     * @param aClass 将会使用到的Http消息转换器类类型
     * @return 返回true则会执行beforeBodyRead
     */
    @Override
    public boolean supports(MethodParameter methodParameter, Type type, Class<? extends HttpMessageConverter<?>> aClass) {
        return true;
    }

    /**
     * 在Http消息转换器执转换，之后执行
     * @param o 转换后的对象
     * @param httpInputMessage 客户端的请求数据
     * @param methodParameter handler方法的参数类型
     * @param type handler方法的参数类型
     * @param aClass 使用的Http消息转换器类类型
     * @return 返回一个新的对象
     */
    @Override
    public Object handleEmptyBody(Object o, HttpInputMessage httpInputMessage, MethodParameter methodParameter, Type type, Class<? extends HttpMessageConverter<?>> aClass) {
        Method method=methodParameter.getMethod();
        System.out.println("66666666666666666666666666  handleEmptyBody"+method);
        log.info("{}.{}",method.getDeclaringClass().getSimpleName(),method.getName());
        return o;
    }

    /**
     * 在Http消息转换器执转换，之前执行
     * @param httpInputMessage 客户端的请求数据
     * @param methodParameter handler方法的参数对象
     * @param type handler方法的参数类型
     * @param aClass 将会使用到的Http消息转换器类类型
     * @return 返回 一个自定义的HttpInputMessage
     */
    @Override
    public HttpInputMessage beforeBodyRead(HttpInputMessage httpInputMessage, MethodParameter methodParameter, Type type, Class<? extends HttpMessageConverter<?>> aClass) throws IOException {
        System.out.println("8888888888888888888888888");
        return httpInputMessage;
    }

    /**
     * 在Http消息转换器执转换，之后执行
     * @param o 转换后的对象
     * @param httpInputMessage 客户端的请求数据
     * @param methodParameter handler方法的参数类型
     * @param type handler方法的参数类型
     * @param aClass 使用的Http消息转换器类类型
     * @return 返回一个新的对象
     */
    @Override
    public Object afterBodyRead(Object o, HttpInputMessage httpInputMessage, MethodParameter methodParameter, Type type, Class<? extends HttpMessageConverter<?>> aClass) {
        Method method=methodParameter.getMethod();
        System.out.println("77777777777777777777777777  afterBodyRead"+method);
        log.info("{}.{}:{}",method.getDeclaringClass().getSimpleName(),method.getName(),JSON.toJSONString(o));
        return o;
    }
}
