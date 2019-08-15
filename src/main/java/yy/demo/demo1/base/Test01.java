package yy.demo.demo1.base;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yinmb
 * @Date 2019/5/29 11:05:49
 */
public class Test01 {
    static String  base = "string";
    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();
        for (int i=0;i< Integer.MAX_VALUE;i++){
            String str = base + base;
            base = str;
            list.add(str.intern());
        }
    }
}
