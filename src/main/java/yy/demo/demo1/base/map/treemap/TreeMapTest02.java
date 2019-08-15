package yy.demo.demo1.base.map.treemap;

import java.util.*;

/**
 * 上面例子是对根据TreeMap的key值来进行排序的，
 * 但是有时我们需要根据TreeMap的value来进行排序。
 * 对value排序我们就需要借助于Collections的sort(List<T> list, Comparator<? super T> c)方法，
 * 该方法根据指定比较器产生的顺序对指定列表进行排序。但是有一个前提条件，
 * 那就是所有的元素都必须能够根据所提供的比较器来进行比较。如下：
 * @author yinmb
 * @Date 2019/5/16 09:29:14
 */
public class TreeMapTest02 {
    public static void main(String[] args) {
        Map<String, String> map = new TreeMap<String, String>();
        map.put("d", "ddddd");
        map.put("b", "bbbbb");
        map.put("a", "aaaaa");
        map.put("c", "ccccc");

        //这里将map.entrySet()转换成list
        List<Map.Entry<String,String>> list = new ArrayList<>(map.entrySet());
        //然后通过比较器来实现排序
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
