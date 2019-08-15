package yy.demo.demo1.thread.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author yinmb
 * @Date 2019/5/13 10:57:51
 */
public class NewSingleThreadExecutorTest {
    public void test(){
        ExecutorService pool = Executors.newSingleThreadExecutor();
        pool.submit(new TestThread());
        pool.submit(new TestThread());
        pool.shutdown();
    }
    public static void main(String[] args) {
        NewSingleThreadExecutorTest newSingleThreadExecutorTest = new NewSingleThreadExecutorTest();
        newSingleThreadExecutorTest.test();
    }
}
