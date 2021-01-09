package yy.demo.demo1.proxy.jdk.demo;

import java.lang.reflect.Proxy;

/**
 * @author ：yinmb@ruyi.ai
 * @date ：Created in 2020/12/16 5:00 下午
 */
public class MyJDKProxy {
	public static void main(String[] args) {
		HelloImpl hello = new HelloImpl();
		MyInvocationHandler handler = new MyInvocationHandler(hello);
		//构造代码实例
		Hello proxyHello = (Hello) Proxy.newProxyInstance(HelloImpl.class.getClassLoader(), HelloImpl.class.getInterfaces(), handler);
		//调用代理方法
		//
		proxyHello.sayHello();
	}
}
