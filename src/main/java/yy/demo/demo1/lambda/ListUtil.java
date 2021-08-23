package com.narwal.utils;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author yinmb
 * @date 2021/7/15 17:39
 */
public class ListUtil {

    /**
     * 从listA里删除listB里有的数据
     *
     * @param listA
     * @param listB
     * @return
     */
    public static List<String> listRemove(List<String> listA, List<String> listB){
        HashSet hs1 = new HashSet(listA);
        HashSet hs2 = new HashSet(listB);
        hs1.removeAll(hs2);
        List<String> listC = new ArrayList<String>();
        listC.addAll(hs1);
        return listC;
    }




    public static void main(String[] args) {
        //  cpList=cpList.stream().collect(Collectors.collectingAndThen(Collectors.toCollection(()->new TreeSet<>(Comparator.comparing(CompanyPosition::getZoneId))),ArrayList::new));

        User map1 = new User();
        map1.setId(3);
        map1.setName("Tom");

        User map2 = new User();
        map2.setId(1);
        map2.setName("Jerry");


        User map3 = new User();
        map3.setId(3);
        map3.setName("Tom");

        User map4 = new User();
        map4.setId(1);
        map4.setName("Tom");

        List<User> list = Lists.newArrayList();
        list.add(map1);
        list.add(map2);
        list.add(map3);

        // 注意：如果过滤多个字段 此方法不合适此方法只适合 一次一次过滤
        list = list.stream().collect(Collectors.collectingAndThen(Collectors.toCollection(()->new TreeSet<>(Comparator.comparing(User::getName))),ArrayList::new));
        list = list.stream().collect(Collectors.collectingAndThen(Collectors.toCollection(()->new TreeSet<>(Comparator.comparing(User::getId))),ArrayList::new));

        System.out.println(list.size());
    }

    static class User {
        private int id;
        private String name;

        public User() {
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
