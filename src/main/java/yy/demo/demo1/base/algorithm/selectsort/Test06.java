package yy.demo.demo1.base.algorithm.selectsort;

/**
 * 简单选择排序
 * @author yinmb
 * @Date 2019/5/6
 */
public class Test06 {

    public int[] init(){
        int[] a={42,14,67,39,32,11};
        return a;
    }

    public void selectSort (int[] a){

        for (int i = 0; i < a.length; i++) {
            if(i < a.length-1) {
                for (int j = i+1; j < a.length; j++) {
                    if (a[i] > a[j]) {
                        int temp = a[i];
                        a[i] = a[j];
                        a[j] = temp;
                    }
                }
            }
        }

        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }

    }

    public static void main(String[] args) {
        Test06 test06 = new Test06();
        test06.selectSort(test06.init());
    }
}
