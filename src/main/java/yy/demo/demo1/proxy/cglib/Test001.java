package yy.demo.demo1.proxy.cglib;
import net.sf.cglib.proxy.Enhancer;
import org.junit.jupiter.api.Test;

/**
 * @author ：yinmb@ruyi.ai
 * @date ：Created in 2020/12/16 6:49 下午
 */
public class Test001 {
	@Test
	public void test(){
		Enhancer enhancer = new Enhancer();
		//将目标类设置为父类，cglib动态代理增强的原理就是子类增强父类,cglib不能增强目标类为final的类和方法
		enhancer.setSuperclass(CglibServiceImpl.class);
		//设置当前类的具体子类(允许为null)
		enhancer.setClassLoader(CglibServiceImpl.class.getClassLoader());
		//设置回调接口,这里的MethodInterceptor实现类回调接口，而我们又实现了MethodInterceptor
		enhancer.setCallback(new CglibProxy());
		//create()方法用于创建cglib动态代理对象
		CglibServiceImpl cglibService = (CglibServiceImpl)enhancer.create();
		//实现CGLib代理调用方法
		System.out.println(cglibService.say());
		System.out.println(cglibService.useCase());
		//通过final修饰的方法，CGlib没办法代理
		System.out.println(cglibService.example());

	}


}
