package yy.demo.demo1.lock;

import java.sql.*;
import java.util.concurrent.CountDownLatch;

/**
 * @author yinmb
 * @Date 2019/3/26 10:11:07
 */
public class LostUpdate implements Runnable{
    private CountDownLatch countDown;
    public LostUpdate(CountDownLatch countDown){
        this.countDown = countDown;
    }

    @Override
    public void run() {
        Connection conn=null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://172.29.2.158:3346/ceis?useUnicode=true&characterEncoding=utf-8&allowMultiQueries=true&useSSL=false",
                    "ceisapp", "Mysql_6800");
        } catch (Exception e) {
            e.printStackTrace();
            return;
        }

        try {
            conn.setAutoCommit(false);
         //   System.out.println("子线程"+Thread.currentThread().getName()+"正在执行");
            //不加锁的情况
            PreparedStatement ps =conn.prepareStatement("select * from test_person where id =1");
            //加锁的情况
           // PreparedStatement ps =conn.prepareStatement("select * from test_person where id =1 for update");
            ResultSet rs=ps.executeQuery();
            int count = 0;

            while(rs.next()){
                count= rs.getInt("p_age");
            }
            System.out.println("子线程"+Thread.currentThread().getName()+"正在执行"+"p_age:"+count);
            count++;
            System.out.println("p_age++:"+count);

            ps =conn.prepareStatement("update test_person set p_age=? where id =1");
            ps.setInt(1, count);
            ps.executeUpdate();
            System.out.println("子线程"+Thread.currentThread().getName()+"正在完成");
            conn.commit();

        } catch (Exception e) {
            try {
                conn.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            e.printStackTrace();
        }
        //表示一次任务完成
        countDown.countDown();
    }
}
