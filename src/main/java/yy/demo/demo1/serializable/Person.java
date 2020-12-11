package yy.demo.demo1.serializable;

import java.io.Serializable;


/**
 * @author ：yinmb@ruyi.ai
 * @date ：Created in 2020/12/10 4:05 下午
 */
public class Person implements Serializable {

	/**
	 * 序列化ID
	 */
	private static final long serialVersionUID = -5809782578272943999L;
	private int age;
	private String name;
	private String sex;

	public int getAge() {
		return age;
	}

	public String getName() {
		return name;
	}

	public String getSex() {
		return sex;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}
}
