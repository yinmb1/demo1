package yy.demo.demo1.base.algorithm.bubblesort;

/**
 * @author yinmb
 * @Date 2019/5/7
 */
public class Test08 {
    public static int[] preparationData() {
        int[] arr = {45, 28, 165, 97, 26, 26, 76, 51, 8, 12, 0, -8, 26};
        return arr;
    }

    public static void bubbleSort(int[] arr) {
        //外层循环控制排序趟数
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                //内层循环控制每一趟排序多少次
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        System.out.println();
        System.out.println("排序后的数组为：");
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }

    public static void main(String[] args) {
        Test08.bubbleSort(Test08.preparationData());
    }
}
