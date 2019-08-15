package yy.demo.demo1.base.initialization;

/**
 * 通过子类引用父类的静态字段，不会导致子类初始化
 * @author yinmb
 * @Date 2019/4/23 16:05:36
 */
public class SSClass{
    static{
        System.out.println("SSClass");
    }
}







