package yy.demo.demo1.lock.lock01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.concurrent.CountDownLatch;

/**
 * @author yinmb
 * @Date 2019/3/26 16:26:49
 */
public class ForUpdate1  implements Runnable{
    private CountDownLatch countDown;
    public ForUpdate1(CountDownLatch countDown){
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
            /*PreparedStatement ps =conn.prepareStatement("select * from LostUpdate where id =1 for update");
            ps.executeQuery();*/
            PreparedStatement ps =conn.prepareStatement("update test_person set p_age =1 where id =1");
            ps.executeUpdate();
            Thread.sleep(10000);

            conn.commit();
            System.out.println("test 1 finish");
          //  countDown.countDown();
        } catch (Exception e) {
            try {
                conn.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            e.printStackTrace();
        }
    }
}
