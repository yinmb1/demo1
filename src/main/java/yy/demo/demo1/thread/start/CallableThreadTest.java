package yy.demo.demo1.thread.start;

import org.junit.jupiter.api.Test;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author yinmb
 * @Date 2019/6/3 10:51:56
 */
public class CallableThreadTest {
    public static void main(String[] args) {
        FutureTask<Integer> ft = new FutureTask<>(() -> {
            int i = 0;
            for (; i < 5; i++) {
                System.out.println(Thread.currentThread().getName() + " " + i);
            }
            return i;
        });
        for (int i = 0; i < 3; i++) {
            System.out.println(Thread.currentThread().getName() + " 的循环变量i的值" + i);
            if (i == 2) {
                new Thread(ft, "有返回值的线程").start();
            }
        }
        try {
            System.out.println("子线程的返回值：" + ft.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void test(){
       FutureTask task =  new FutureTask<Integer>(()->{
            int i = 0 ;
            System.out.println(Thread.currentThread().getName()+"123456");
            return i;
        });
       new Thread(task,"xiancheng1").start();

    }

}
