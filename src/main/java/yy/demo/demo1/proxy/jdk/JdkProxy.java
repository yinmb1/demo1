package yy.demo.demo1.proxy.jdk;

/**
 * @author ：yinmb@ruyi.ai
 * @date ：Created in 2020/12/16 4:22 下午
 */

import lombok.extern.slf4j.Slf4j;
import org.joda.time.DateTime;

import java.lang.reflect.Proxy;

/**
 * JDK1.6+ 底层提供的动态代理
 */
@Slf4j
public class JdkProxy {

	private Object object;

	public JdkProxy(Object object){
		this.object = object;
	}

	/**
	 * 封装代理方法,取代实现InvocationHandler
	 * @return
	 */
	public Object getProxyInstance() {
		long startTime = System.currentTimeMillis();
		return Proxy.newProxyInstance(object.getClass().getClassLoader(), object.getClass().getInterfaces(), (proxy, method, args) -> {
			log.info(String.format("开始操作你的需求: %s ",startTime));
			//进行代理
			Object invoke = method.invoke(object, args);

			long endTime = System.currentTimeMillis();
			log.info(String.format("操作此需求总共耗时: %s 毫秒",(endTime- startTime)));

			return invoke;
		});
	}

//    (proxy, method ,args) -> method.invoke(proxy,args)
//    =
//    new InvocationHandler() {
//        @Override
//        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
//            return method.invoke(object,args);
//        }
}


