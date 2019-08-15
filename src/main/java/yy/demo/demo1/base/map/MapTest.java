package yy.demo.demo1.base.map;

import java.util.*;

/**
 * @author yinmb
 * @Date 2019/4/30 14:14:46
 */
public class MapTest {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<String, String>();
        long t1=System.currentTimeMillis();
        map.put("1", "Level 1");
        map.put("2", "Level 2");
        map.put("3", "Level 3");
        map.put("a", "Level a");
        map.put("b", "Level b");
        map.put("c", "Level c");
        Iterator<Map.Entry<String, String>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String, String> e = it.next();
            System.out.println("Key: " + e.getKey() + ";   Value: " + e.getValue());
        }
        long t2 =System.currentTimeMillis();
        System.out.println("hashMap:"+(t2-t1));
        System.out.println("======================================");
        Map<String, String> map1 = new TreeMap<String, String>();
        t1=System.currentTimeMillis();
        map1.put("1", "Level 1");
        map1.put("2", "Level 2");
        map1.put("3", "Level 3");
        map1.put("a", "Level a");
        map1.put("b", "Level b");
        map1.put("c", "Level c");
        Iterator<Map.Entry<String, String>> it1 = map1.entrySet().iterator();
        while (it1.hasNext()) {
            Map.Entry<String, String> e1 = it1.next();
            System.out.println("Key: " + e1.getKey() + ";   Value: " + e1.getValue());
        }
        t2 =System.currentTimeMillis();
        System.out.println("TreeMap:"+(t2-t1));
        System.out.println("======================================");
        Map<String, String> map2 = new LinkedHashMap<>();
        t1=System.currentTimeMillis();
        map2.put("1", "Level 1");
        map2.put("2", "Level 2");
        map2.put("3", "Level 3");
        map2.put("a", "Level a");
        map2.put("b", "Level b");
        map2.put("c", "Level c");
        Iterator<Map.Entry<String, String>> it2 = map1.entrySet().iterator();
        while (it2.hasNext()) {
            Map.Entry<String, String> e2 = it2.next();
            System.out.println("Key: " + e2.getKey() + ";   Value: " + e2.getValue());
        }
        t2 =System.currentTimeMillis();
        System.out.println("LinkHashMap:"+(t2-t1));
    }
}
