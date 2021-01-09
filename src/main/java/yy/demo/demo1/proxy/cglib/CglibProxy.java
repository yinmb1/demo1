package yy.demo.demo1.proxy.cglib;

/**
 * @author ：yinmb@ruyi.ai
 * @date ：Created in 2020/12/16 6:44 下午
 */

import lombok.extern.slf4j.Slf4j;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * 实现CGLib核心接口 MethodInterceptor
 */
@Slf4j
public class CglibProxy implements MethodInterceptor {

	private Long startTime;

	public CglibProxy(){
		startTime = System.currentTimeMillis();
	}

	/**
	 * 回调接口的方法
	 * 回调接口的方法执行的条件是：代理对象执行目标方法时会调用回调接口的方法
	 * @param obj
	 * @param method
	 * @param args
	 * @param proxy
	 * @return
	 * @throws Throwable
	 */
	@Override
	public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
		log.info(String.format("方法名: %s",method.getName()));
		log.info(String.format("开始执行日期: %s ", startTime));

		Object o = proxy.invokeSuper(obj, args);

		long endTime = System.currentTimeMillis();
		log.info(String.format("方法总共执行时间: %s 毫秒",endTime - startTime));
		return o;
	}
}


