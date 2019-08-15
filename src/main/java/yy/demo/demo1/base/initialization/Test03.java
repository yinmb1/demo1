package yy.demo.demo1.base.initialization;

/**
 * @author yinmb
 * @Date 2019/4/23 09:36:27
 */
public class Test03
{


        static {
            a = 2;
            b = 2;
        }

        static int a;
        static int b = 1;

        public Test03() {
            e = 3;
        }

        {
            c = 2;
            d = 2;
            e = 2;
        }

        int c;
        int d = 1;
        int e = 1;

        public static void main(String[] args) {
            System.out.println(Test03.a);//2
            System.out.println(Test03.b);//1
            System.out.println(new Test03().c);//2
            System.out.println(new Test03().d);//1
            System.out.println(new Test03().e);//3
        }

}
