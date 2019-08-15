package yy.demo.demo1.base.initialization;

/**
 * @author yinmb
 * @Date 2019/4/23 16:21:55
 */
public class NotInitialization {
    public static void main(String[] args) {
        //1 通过子类引用父类的静态字段，不会导致子类初始化
        // System.out.println(SubClass.value);

        //2 通过数组定义来引用类，不会触发此类的初始化
        // SClass[] sca = new SClass[10];

        //3 常量在编译阶段会存入调用类的常量池中，本质上并没有直接引用到定义常量的类，因此不会触发定义常量的类的初始化
        System.out.println(ConstClass.CONSTANT);
    }
}
