package yy.demo.demo1.thread.start;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * @author yinmb
 * @Date 2019/6/3 10:31:59
 */
public class MyCallable implements Callable {
    public static void main(String[] args) {
        int taskSize = 10;
        //创建一个线程池
        ExecutorService pool = Executors.newFixedThreadPool(taskSize);
        // 创建多个有返回值的任务
        List<Future> list = new ArrayList<Future>();
        for (int i = 0; i < taskSize; i++) {
            Callable c = new MyCallable();
             // 执行任务并获取 Future 对象
            Future f = pool.submit(c);
            list.add(f);
        }
        // 关闭线程池
        pool.shutdown();
        // 获取所有并发任务的运行结果
        for (Future f : list) {
            // 从 Future 对象上获取任务的返回值，并输出到控制台
            try {
                System.out.println("res：" + f.get().toString());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public Object call() throws Exception {
        return "nihao";
    }
}
