package yy.demo.demo1.base.initialization;

/**
 * @author yinmb
 * @Date 2019/4/23 08:56:44
 */
public class Test01 {

        public Test01() {
            System.out.println("Constructor A.");
        }

        {
            System.out.println("Instance Block A.");
        }
        static {
            System.out.println("Static Block A.");
        }

        public static void main(String[] args) {
            new Test01();/*
             * Static Block A. Instance Block A. Constructor A.
             */
        }
    }

    class B extends Test01 {
        public B() {
            System.out.println("Constructor B.");
        }

        {
            System.out.println("Instance Block B.");
        }
        static {
            System.out.println("Static Block B.");
        }

        public static void main(String[] args) {
            new Test01();/*
             * Static Block A. Static Block B. Instance Block A. Constructor A.
             */
            System.out.println();
            new B();/*
             * Instance Block A. Constructor A. Instance Block B. Constructor B.
             */// 静态成员和静态初始化块只会执行一次。
        }
    }

