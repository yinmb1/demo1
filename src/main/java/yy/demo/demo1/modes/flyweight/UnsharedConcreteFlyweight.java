package yy.demo.demo1.modes.flyweight;

/**
 * @author yinmb
 * @Date 2019/1/30 11:30:30
 */
public class UnsharedConcreteFlyweight extends Flyweight {
    public UnsharedConcreteFlyweight(String extrinsic) {
        super(extrinsic);
    }

    @Override
    public void operate(int extrinsic) {
        System.out.println("不共享的具体Flyweight:" + extrinsic);
    }


}
