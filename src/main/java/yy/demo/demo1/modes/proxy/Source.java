package yy.demo.demo1.modes.proxy;

/**
 * @author yinmb
 * @Date 2019/1/30 09:27:25
 */
public class Source implements Sourceable1 {
    @Override
    public void method() {
        System.out.println("the original method!");
    }
}
