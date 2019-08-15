package yy.demo.demo1.jvm.reference;

/**
 * @author yinmb
 * @Date 2019/4/22 20:00:52
 */
public class StringTest
{
    public static void test(String str) {
        str = "433242";  //   = 赋值，而不是 append 操作
    }

    public static void main(String[] args) {
        String string = new String("Hello");
        System.out.println(string);
        test(string);
        System.out.println(string);  // what is it now ?
    }
}
