package yy.demo.demo1.base.algorithm.Test02;

import java.util.Objects;

/**
 * 给出一个排序好的数组和一个数，求数组中连续元素的和等于所给数的子数组
 * @author yinmb
 * @Date 2019/5/5 18:47:13
 */
public class Test04{
    public void init(){
        int[] a={1,2,3,4,5,7,10,3,7,26,32};
        int e = 10;
        Test04 test04 = new Test04();
        test04.toSort(a,e);
    }

    public void toSort(int[] a,int e){
        for (int i = 0; i < a.length; i++) {

            int sum = 0;
            int left = i;
            int right = i;

            while(sum <e ){
                sum = sum+a[right++];
            } if (Objects.equals(sum,e)){
                for (int j = left; j < right; j++) {
                    System.out.print(a[j]);
                }
                System.out.println("");
            }
        }
    }
    public static void main(String[] args) {
        Test04 test04 = new Test04();
        test04.init();
    }

}
