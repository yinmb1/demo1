package yy.demo.demo1.modes;

import yy.demo.demo1.modes.builder.*;

/**
 * @author yinmb
 * @Date 2019/1/24 15:56:33
 */
public class BuilderTest {
    public static void main(String[] args) {
        Director director = new Director(new HPBuilder());
        Computer hpPC = director.construct();
        System.out.println(hpPC.toString());

        director.setBuilder(new LenovoBuilder());
        Computer lenovoPC = director.construct();
        System.out.println(lenovoPC.toString());

    }
}
