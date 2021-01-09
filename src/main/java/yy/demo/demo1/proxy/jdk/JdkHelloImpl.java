package yy.demo.demo1.proxy.jdk;

/**
 * @author ：yinmb@ruyi.ai
 * @date ：Created in 2020/12/16 4:21 下午
 */
public class JdkHelloImpl implements JdkHello {

	@Override
	public String hello() {
		return "hello";
	}
	@Override
	public String world() {
		return "world";
	}
}

