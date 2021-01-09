package yy.demo.demo1.proxy.jdk;

/**
 * @author ：yinmb@ruyi.ai
 * @date ：Created in 2020/12/16 4:40 下午
 */

import org.junit.jupiter.api.Test;

/**
 * 测试jdk动态代理
 */
public class JdkProxyTest {

	@Test
	public void test(){
		//通过代理类实现调用JdkHelloImpl实现类
		JdkHello jdkHello = new JdkHelloProxy();
		//执行代理操作
		JdkHello jdkHelloProxy = (JdkHello)new JdkProxy(jdkHello).getProxyInstance();
		System.out.println(jdkHelloProxy.hello());

		//经过final修饰的方法
		System.out.println(jdkHelloProxy.world());
	}
}


