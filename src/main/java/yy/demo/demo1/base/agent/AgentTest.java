package yy.demo.demo1.base.agent;

import yy.demo.demo1.base.agent.agentone.DynamicProxyface;
import yy.demo.demo1.base.agent.agentone.DynamicSon;
import yy.demo.demo1.base.agent.agentone.StandardInvocation;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * @author yinmb
 * @Date 2019/5/20 14:41:38
 */
public class AgentTest {
    public static void main(String[] args) {
        //创建一个被代理者
        DynamicSon dynamicSon = new DynamicSon();
        //创建一个InvocationHandler，描述我们希望代理者执行哪些操作
        InvocationHandler i = new StandardInvocation(dynamicSon);
        //通过刚才创建的InvocationHandler，创建真正的代理者。第一个参数是类加载器，第二个参数是这个代理者实现哪些接口
        DynamicProxyface pxy = (DynamicProxyface) Proxy.newProxyInstance(DynamicSon.class.getClassLoader(), new Class[]{DynamicProxyface.class}, i);
        pxy.printSth("Hi");
    }
}
