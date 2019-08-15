package yy.demo.demo1.base.initialization;

/**
 * @author yinmb
 * @Date 2019/4/23 16:08:16
 */
public class SClass extends SSClass{
        static{
            System.out.println("SClass init!");
        }

        public static int value = 123;

        public SClass(){
            System.out.println("init SClass");
        }
    }

