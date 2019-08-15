package yy.demo.demo1.lock.lock01;

import yy.demo.demo1.lock.lock01.ForUpdate1;
import yy.demo.demo1.lock.lock01.ForUpdate2;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author yinmb
 * @Date 2019/3/26 16:36:40
 */
public class TestForUpdate {
    public static void main(String[] args) throws InterruptedException {
        final int THREAD_COUNT=10;

        ExecutorService threadPool= Executors.newFixedThreadPool(THREAD_COUNT);
        CountDownLatch count=new CountDownLatch(1);

        threadPool.execute(new ForUpdate1(count));
        threadPool.execute(new ForUpdate2(count));

        threadPool.shutdown();
        count.await();
        System.out.println(count);
        System.out.println("finish");


    }
}
