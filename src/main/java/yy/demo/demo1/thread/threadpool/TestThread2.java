package yy.demo.demo1.thread.threadpool;

/**
 * @author yinmb
 * @Date 2019/5/13 11:18:50
 */
public class TestThread2 implements Runnable {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+"haha");
    }

}
