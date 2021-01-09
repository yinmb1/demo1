package yy.demo.demo1.proxy.cglib;

/**
 * @author ：yinmb@ruyi.ai
 * @date ：Created in 2020/12/16 6:44 下午
 */
public class CglibServiceImpl{
	public String say() {
		return "say";
	}

	public String useCase() {
		return "useCase";
	}

	/**
	 * final修饰的方法,CGLib不能代理
	 * @return
	 */
	public final String example(){
		return "劳资的东西你别碰。。。";
	}
}

