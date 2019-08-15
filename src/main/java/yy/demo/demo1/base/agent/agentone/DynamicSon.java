package yy.demo.demo1.base.agent.agentone;

/**
 * @author yinmb
 * @Date 2019/5/20 15:04:41
 */
public class DynamicSon implements DynamicProxyface{
    @Override
    public void printMe() {
        System.out.println("I'm Cls!");
    }

    @Override
    public void printSth(String str) {
        System.out.println(str);
    }
}
