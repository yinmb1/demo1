package yy.demo.demo1.thread.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author yinmb
 * @Date 2019/5/10 17:20:01
 */
public class NewCachedThreadPoolTest {

    public void test() throws InterruptedException{
        ExecutorService pool =  Executors.newCachedThreadPool();
        pool.submit(new TestThread());
        // 当线程池中，没有可用线程，会重新创建一个线程
        //下面的语句开启就是为了让第一个提交的线程执行完
        Thread.sleep(6000);
        pool.submit(new TestThread());
        pool.shutdown();
    }


    public static void main(String[] args) throws InterruptedException {
        NewCachedThreadPoolTest newCachedThreadPoolTest = new NewCachedThreadPoolTest();
        newCachedThreadPoolTest.test();
    }
}
