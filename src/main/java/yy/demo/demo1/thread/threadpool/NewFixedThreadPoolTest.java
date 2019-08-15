package yy.demo.demo1.thread.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *
 * @author yinmb
 * @Date 2019/5/13 10:52:16
 */
public class NewFixedThreadPoolTest {
    public void test(){
        //创建只含两条线程的线程池
        ExecutorService pool = Executors.newFixedThreadPool(2);
        pool.submit(new TestThread());//执行1线程
        pool.submit(new TestThread());//执行2线程
        pool.submit(new TestThread());//先等待，等1或者2线程空闲执行1或者2线程
        pool.shutdown();
    }
    public static void main(String[] args) {
        NewFixedThreadPoolTest newFixedThreadPoolTest = new NewFixedThreadPoolTest();
        newFixedThreadPoolTest.test();

    }
}
