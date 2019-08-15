package yy.demo.demo1.thread.start;

/**
 * @author yinmb
 * @Date 2019/6/3 09:57:59
 */
public class MyRunnable extends Object implements Runnable
{
    @Override
    public void run() {
        System.out.println("MyRunnable start");
        System.out.println(Thread.currentThread().getName()+"run---");
    }

    public static void main(String[] args) {
        MyRunnable myRunnable = new MyRunnable();
        Thread thread = new Thread(myRunnable);
        thread.start();

        new Thread(myRunnable).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("haha");
            }
        }).start();

        new Thread(()->{
            System.out.println(Thread.currentThread().getName()+"j");
        },"haha线程").start();


    }


}
