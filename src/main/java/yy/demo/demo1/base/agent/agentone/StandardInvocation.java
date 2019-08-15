package yy.demo.demo1.base.agent.agentone;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author yinmb
 * @Date 2019/5/20 15:06:01
 */
public class StandardInvocation implements InvocationHandler {
    private Object obj;

    public StandardInvocation(Object obj){
        this.obj=obj;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("before method excute!");
        Object result = method.invoke(obj, args);
        System.out.println("after method excute!");
        return result;
    }
}
