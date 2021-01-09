package yy.demo.demo1.proxy.jdk;

import lombok.extern.slf4j.Slf4j;

/**
 * @author ：yinmb@ruyi.ai
 * @date ：Created in 2020/12/16 4:21 下午
 */
@Slf4j
public class JdkHelloProxy implements JdkHello {

	private JdkHello jdkHello = new JdkHelloImpl();

	@Override
	public String hello() {
		log.info("通过动态代理执行hello");
		return jdkHello.hello();
	}

	@Override
	public final String world() {
		log.info("通过动态代理执行world");
		return jdkHello.world();
	}
}

