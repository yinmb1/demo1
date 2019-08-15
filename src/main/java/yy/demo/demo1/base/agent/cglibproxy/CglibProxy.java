package yy.demo.demo1.base.agent.cglibproxy;

/**
 * @author yinmb
 * @Date 2019/5/24 15:48:29
 */
import java.lang.reflect.Method;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

public class CglibProxy implements MethodInterceptor{

    //增强器，动态代码生成器
    Enhancer enhancer = new Enhancer();

    /**
     * 创建代理对象
     * @param clazz
     * @return 返回代理对象
     */
    public Object getProxy(Class clazz){
        //设置父类，也就是被代理的类(目标类)
        enhancer.setSuperclass(clazz);
        //设置回调（在调用父类方法时，回调this.intercept()）
        enhancer.setCallback(this);
        //通过字节码技术动态创建子类实例(动态扩展了UserServiceImpl类)
        return enhancer.create();
    }

    /**
     * 拦截方法：在代理实例上拦截并处理目标方法的调用，返回结果
     * obj:目标对象代理的实例;
     * method:目标对象调用父类方法的method实例;
     * args:调用父类方法传递参数;
     * proxy:代理的方法去调用目标方法
     */
    public Object intercept(Object obj,Method method,Object[] args,MethodProxy proxy)
            throws Throwable{

        System.out.println("--------测试intercept方法的四个参数的含义-----------");
        System.out.println("obj:"+obj.getClass());
        System.out.println("method:"+method.getName());
        System.out.println("proxy:"+proxy.getSuperName());
        if(args!=null&&args.length>0){
            for(Object value : args){
                System.out.println("args:"+value);
            }
        }

        //目标方法之前执行
        System.out.println("do sth Before...");
        //目标方法调用
        //通过代理类实例调用父类的方法，即是目标业务类方法的调用
        Object result = proxy.invokeSuper(obj, args);
        //目标方法之后执行
        System.out.println("do sth After...\n");
        return result;
    }
}