package yy.demo.demo1.log.advice;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import com.alibaba.fastjson.serializer.SerializerFeature;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;
import yy.demo.demo1.exception.entity.Result;
import yy.demo.demo1.log.SysInterfaceLog;
import yy.demo.demo1.log.SysInterfaceLogService;
import yy.demo.demo1.log.annotation.NoControllerLog;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * ResponseBody 响应日志输出
 *
 * @author yinmb
 * @version 1.0.0
 * @date 2017/1/16
 */
@ControllerAdvice
@Slf4j
public class LogResponseBodyAdvice implements ResponseBodyAdvice {


    @Override
    public boolean supports(MethodParameter methodParameter, Class aClass) {
        return true;
    }

    @Override
    public Object beforeBodyWrite(Object o, MethodParameter methodParameter, MediaType mediaType, Class aClass, ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {
        Method method = methodParameter.getMethod();
        methodParameter.getMethod();

        String url = serverHttpRequest.getURI().toASCIIString();
        log.info("{}.{},url={},result={}", method.getDeclaringClass().getSimpleName(), method.getName(), url, JSON.toJSONString(o));
        System.out.println("**************************" + JSON.toJSONString(o));
        NoControllerLog controllerLog = method.getAnnotation(NoControllerLog.class);
        if (controllerLog != null) {
            // todo
            System.out.println("保存日志。。。。。。等等");
        }

        return o;
    }
}
