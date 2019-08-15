package yy.demo.demo1.base.agent.cglibproxy;

/**
 * @author yinmb
 * @Date 2019/5/24 16:06:11
 */
public class CglibProxyTest {
    public static void main(String[] args){
        CglibProxy proxy=new CglibProxy();
        //通过java.lang.reflect.Proxy的getProxy()动态生成目标业务类的子类，即是代理类，再由此得到代理实例
        //通过动态生成子类的方式创建代理类
        IUserService target=(IUserService)proxy.getProxy(UserServiceImpl.class);
        target.addUser();
        target.deleteUser();
    }
}
