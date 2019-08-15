package yy.demo.demo1.modes;

import yy.demo.demo1.modes.proxy.Proxy;
import yy.demo.demo1.modes.proxy.Sourceable1;

/**
 * @author yinmb
 * @Date 2019/1/30 09:30:02
 */
public class ProxyTest {
    public static void main(String[] args) {
        Sourceable1 source = new Proxy();
        source.method();
    }
}
