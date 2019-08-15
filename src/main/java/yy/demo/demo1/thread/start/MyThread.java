package yy.demo.demo1.thread.start;

/**
 * @author yinmb
 * @Date 2019/6/3 09:49:08
 */
public class MyThread extends Thread {
    public void run() {

        System.out.println("MyThread.run()");

    }

    public static void main(String[] args) {
        MyThread myThread1 = new MyThread();

        myThread1.start();

    }


}
