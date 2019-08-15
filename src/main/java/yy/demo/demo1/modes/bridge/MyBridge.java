package yy.demo.demo1.modes.bridge;

/**
 * @author yinmb
 * @Date 2019/1/30 10:12:45
 */
public class MyBridge extends Bridge {
    public void method(){
        getSource().method();
    }
}
