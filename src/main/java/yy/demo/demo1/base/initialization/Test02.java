package yy.demo.demo1.base.initialization;

/**
 * @author yinmb
 * @Date 2019/4/23 09:33:32
 */
public class Test02 {
    static {
        a = 3;
        // int b=a;//Cannot reference a field before it is defined
        // System.out.println(a);//Cannot reference a field before it is defined
        b = 3;
    }
    static int a = 1;
    static int b;

    public static void main(String[] args) {
        System.out.println(SubClass.value);
    }


}
