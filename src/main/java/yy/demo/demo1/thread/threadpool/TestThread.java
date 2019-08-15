package yy.demo.demo1.thread.threadpool;

/**
 * @author yinmb
 * @Date 2019/5/10 16:54:54
 */
public class TestThread implements Runnable  {

    @Override
    public void run() {

        for(int i=0;i<10;i++){
            System.out.println(Thread.currentThread().getName()+":"+i);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
