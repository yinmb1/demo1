package yy.demo.demo1.base.set;



import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * @author yinmb
 * @Date 2019/5/21 15:36:04
 */
public class SetTest {
    @Test
    public void test10() throws Exception {
        Set<String> set=new HashSet<>();
        set.add("test");
        set.add("test2");
        set.add("test3");
        Iterator<String> iterator=set.iterator();
        while (iterator.hasNext()){
            String curr=iterator.next();
            System.out.println(curr);
            if(curr.equals("test")){
                iterator.remove();
            }
        }
    }
}
