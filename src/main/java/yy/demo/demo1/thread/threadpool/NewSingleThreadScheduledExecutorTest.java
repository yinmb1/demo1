package yy.demo.demo1.thread.threadpool;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @author yinmb
 * @Date 2019/5/13 11:14:58
 */
public class NewSingleThreadScheduledExecutorTest {
    public static void test(){
        ScheduledExecutorService pool = Executors.newSingleThreadScheduledExecutor();
        //pool.scheduleAtFixedRate(new TestThread2(), 3, 2, TimeUnit.SECONDS);//首次在3秒后执行，接着每2秒执行一次,不可加pool.shutdown();
        //pool.scheduleWithFixedDelay(new TestThread2(), 3, 2, TimeUnit.SECONDS);//首次在3秒后执行，接着在第一次结束后3秒后执行一直，注意是前一次执行完后，不可加pool.shutdown();
        pool.schedule(new TestThread2(), 3, TimeUnit.SECONDS);//在3秒后执行
        pool.shutdown();
    }
    public static void main(String[] args) {
        NewSingleThreadScheduledExecutorTest.test();
    }

}
