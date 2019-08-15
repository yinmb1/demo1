package yy.demo.demo1.base.statictest;

/**
 * @author yinmb
 * @Date 2019/5/30 09:11:10
 */
public class Outer {

    class Inner {}

    public static void foo() { new Outer().new Inner(); }

    public void bar() { new Inner(); }

    public static void main(String[] args) {
        new Outer().new Inner();
    }
}
