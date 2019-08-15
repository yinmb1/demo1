package yy.demo.demo1.base.initialization;

/**
 * @author yinmb
 * @Date 2019/4/23 09:44:53
 */
public class Test04 {



        public static void main(String[] args) {
            staticFunction();
        }

        static Test04  st = new Test04 ();

        static {
            System.out.println("1");
        }

        {
            System.out.println("2");
        }

        Test04 () {
            System.out.println("3");
            System.out.println("a=" + a + ",b=" + b);
        }

        public static void staticFunction() {
            System.out.println("4");
        }

        int a = 110;
        static int b = 112;

}
