package yy.demo.demo1.base.algorithm.quicksort;

/**
 * @author yinmb
 * @Date 2019/8/7 16:07:04
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] arr = { 18, 25, 16, 11, 12, 14, 21, 8, 22 };
        quickSort(arr, 0, arr.length - 1);
        System.out.println("排序后:");
        for (int i : arr) {
            System.out.println(i);
        }
    }

    private static void quickSort(int[] arr,int low,int high){
        //第一次排序，以第一位开始，返回下标
        int index =getIndex(arr,low,high);
        if(low < high){
            //左侧 防止小标溢出
            if(index != 0) {
                quickSort(arr, low, index - 1);
            }

            //右侧 防止上标溢出
            if(index < arr.length-1){
                quickSort(arr,index+1,high);
            }

        }
    }

    private static int getIndex(int[] arr,int low,int high){
        int temp = arr[low];

        while(low < high){
            //大于等于temp放在右侧,high--
            while(low < high && arr[high] >= temp){
                high--;
            }
            arr[low]=arr[high];
            //小于temp放左侧，low++
            while (low < high && arr[low] <= temp) {
                low++;
            }
            arr[high]=arr[low];
        }
        //此时low=high
        arr[low]=temp;
        return low;
    }
}
