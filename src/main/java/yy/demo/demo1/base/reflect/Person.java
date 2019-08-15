package yy.demo.demo1.base.reflect;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author yinmb
 * @Date 2019/4/1 16:49:32
*/
    public class Person implements Serializable {

    private String name;
    private int age;

    private void getTest(String tom,String jac){
        System.out.println("123"+tom+jac);
    }


    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public static void main(String[] args) throws IntrospectionException, InvocationTargetException, IllegalAccessException, NoSuchMethodException {
        Person person = new Person("luoxn28", 23);

        Class clazz = person.getClass();
        System.out.println(clazz);
        Method method = clazz.getDeclaredMethod("getTest",String.class,String.class);
        method.invoke(person,"321","456");
        Field[] fields = clazz.getDeclaredFields();

        for (Field field : fields) {
            String key = field.getName();
           // PropertyDescriptor descriptor = new PropertyDescriptor(key, clazz);
           // Method method = descriptor.getReadMethod();
           // Object value = method.invoke(person);

            System.out.println(field.get(person));

          //  System.out.println(key + ":" + value);

        }

    }

}




