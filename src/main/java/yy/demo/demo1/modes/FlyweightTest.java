package yy.demo.demo1.modes;

import yy.demo.demo1.modes.flyweight.Flyweight;
import yy.demo.demo1.modes.flyweight.FlyweightFactory;
import yy.demo.demo1.modes.flyweight.UnsharedConcreteFlyweight;

/**
 * @author yinmb
 * @Date 2019/1/30 11:32:59
 */
public class FlyweightTest {

    public static void main(String[] args) {
        int extrinsic = 22;

        Flyweight flyweightX = FlyweightFactory.getFlyweight("X");
        flyweightX.operate(++ extrinsic);

        Flyweight flyweightY = FlyweightFactory.getFlyweight("Y");
        flyweightY.operate(++ extrinsic);

        Flyweight flyweightZ = FlyweightFactory.getFlyweight("Z");
        flyweightZ.operate(++ extrinsic);

        Flyweight flyweightReX = FlyweightFactory.getFlyweight("X");
        flyweightReX.operate(++ extrinsic);

        Flyweight unsharedFlyweight = new UnsharedConcreteFlyweight("X");
        unsharedFlyweight.operate(++ extrinsic);
    }
}
