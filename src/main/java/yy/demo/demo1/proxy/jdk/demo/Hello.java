package yy.demo.demo1.proxy.jdk.demo;

/**
 * @author ：yinmb@ruyi.ai
 * @date ：Created in 2020/12/16 4:58 下午
 */

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

interface Hello {
	void sayHello();
}

class HelloImpl implements Hello {

	@Override
	public void sayHello() {
		System.out.println("my hello");
	}

}

class MyInvocationHandler implements InvocationHandler {
	private Object target;

	public MyInvocationHandler(Object target) {
		super();
		this.target = target;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println("proxy invoke sayhello");
		Object result = method.invoke(target, args);
		return result;
	}
}




