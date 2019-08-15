package yy.demo.demo1;

/**
 * @author yinmb
 * @Date 2019/4/8 14:50:01
 */
public class Test01 {
    public static void main(String[] args) {
        Test01 test01 = new Test01();
        System.out.println(test01.convertTime("20190408"));


    }
    private static String convertTime(String timeStr) {
        try {
            return timeStr.substring(0, 4) + "/" + timeStr.substring(4, 6) + "/" + timeStr.substring(6, 8);
        } catch (Exception e) {
           // log.error(e.getMessage(), e);
            return timeStr;
        }
    }
}
