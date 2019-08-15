package yy.demo.demo1.modes;

import yy.demo.demo1.modes.iterator.Container;
import yy.demo.demo1.modes.iterator.Iterator;
import yy.demo.demo1.modes.iterator.MyContainer;

/**
 * @author yinmb
 * @Date 2019/1/24 09:22:23
 */
public class IteratorTest {
    public static void main(String[] args) {

        //创建一个自定义容器，直接使用ArrayList的实现，仅仅示例作用
        Container strContainer = new MyContainer();
        strContainer.put("001");
        strContainer.put("002");
        strContainer.put("003");

        Iterator myIterator = strContainer.iterator();
        //使用举例
        System.out.println("------------------next、hasNext示例------------------");
        System.out.println(myIterator.first());
        System.out.println(myIterator.next());
        System.out.println(myIterator.hasNext());
        System.out.println(myIterator.next());
        System.out.println(myIterator.hasNext());
        System.out.println(myIterator.next());
        System.out.println(myIterator.hasNext());

        //使用举例
        System.out.println("------------------previous、hasNext示例------------------");
        System.out.println(myIterator.previous());
        System.out.println(myIterator.previous());
        System.out.println(myIterator.previous());
        System.out.println(myIterator.hasNext());

        //使用迭代器遍历
        System.out.println("------------------迭代器遍历示例------------------");
        System.out.println(myIterator.first());
        while(myIterator.hasNext()){
            System.out.println(myIterator.next());
        }
    }
}
