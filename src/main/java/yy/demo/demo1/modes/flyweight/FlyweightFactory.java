package yy.demo.demo1.modes.flyweight;

import java.util.HashMap;

/**
 * @author yinmb
 * @Date 2019/1/30 11:31:15
 */
public class FlyweightFactory {
    /**
     * 定义一个池容器
     */
    private static HashMap<String, Flyweight> pool = new HashMap<>();

    /**
     * 享元工厂
     */
    public static Flyweight getFlyweight(String extrinsic) {
        Flyweight flyweight = null;
        //池中有该对象
        if(pool.containsKey(extrinsic)) {
            flyweight = pool.get(extrinsic);
            System.out.print("已有 " + extrinsic + " 直接从池中取---->");
        } else {
            //根据外部状态创建享元对象
            flyweight = new ConcreteFlyweight(extrinsic);
            //放入池中
            pool.put(extrinsic, flyweight);
            System.out.print("创建 " + extrinsic + " 并从池中取出---->");
        }

        return flyweight;
    }
}
