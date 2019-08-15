package yy.demo.demo1.base.map.hashmap;

import java.util.*;

/**
 * 我们都是HashMap的值是没有顺序的，他是按照key的HashCode来实现的。
 * 对于这个无序的HashMap我们要怎么来实现排序呢？参照TreeMap的value排序，
 * 我们一样的也可以实现HashMap的排序。
 * @author yinmb
 * @Date 2019/5/16 09:43:50
 */
public class HashMapTest {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<String, String>();
        map.put("c", "ccccc");
        map.put("a", "aaaaa");
        map.put("b", "bbbbb");
        map.put("d", "ddddd");

        List<Map.Entry<String,String>> list = new ArrayList<Map.Entry<String,String>>(map.entrySet());
        Collections.sort(list,new Comparator<Map.Entry<String,String>>() {
            //升序排序
            @Override
            public int compare(Map.Entry<String, String> o1,
                               Map.Entry<String, String> o2) {
                return o1.getValue().compareTo(o2.getValue());
            }

        });

        for(Map.Entry<String,String> mapping:list){
            System.out.println(mapping.getKey()+":"+mapping.getValue());
        }
    }
}
