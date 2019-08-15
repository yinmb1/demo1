package yy.demo.demo1.base.algorithm.insertsort;

import yy.demo.demo1.base.algorithm.bubblesort.Test08;

/**
 * 插入排序
 * @author yinmb
 * @Date 2019/7/30 15:52:56
 */
public class InsertSort {


    public void insertSort(int[] a,int len) {
        int begin = 1;
        int i = 0;
        while (begin < len) {
            int key = a[begin];
            for (i = begin - 1; i >= 0; i--) {
                if (a[i] <= key)    //稳定的
                {
                    a[i + 1] = key;
                    break;
                }
                a[i + 1] = a[i];
            }
            if (i < 0){
                a[0] = key;//说明找完了整个有序子序列都没找到
            }
            begin++;
        }
        for (int i1 = 0; i1 < a.length; i1++) {
            System.out.println(a[i1]);
        }
    }

    public static int[] preparationData() {
        int[] arr = {45, 28, 165, 97, 26, 26, 76, 51, 8, 12, 0, -8, 26};
        return arr;
    }

    public static void main(String[] args) {
        InsertSort insertSort =new InsertSort();
        insertSort.insertSort(InsertSort.preparationData(),10);
    }
}
