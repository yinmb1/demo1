package yy.demo.demo1.modes.flyweight;

/**
 * @author yinmb
 * @Date 2019/1/30 11:29:29
 */
public class ConcreteFlyweight extends Flyweight {
    //接受外部状态
    public ConcreteFlyweight(String extrinsic) {
        super(extrinsic);
    }

    /**
     * 根据外部状态进行逻辑处理
     */
    @Override
    public void operate(int extrinsic) {
        System.out.println("具体Flyweight:" + extrinsic);
    }
}
