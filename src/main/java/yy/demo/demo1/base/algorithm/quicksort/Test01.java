package yy.demo.demo1.base.algorithm.quicksort;

/**
 * @author yinmb
 * @Date 2019/8/8 15:46:26
 */
public class Test01 {
    public static void main(String[] args) {
        //int[] arr = { 49, 38, 65, 97, 23, 22, 76, 1, 5, 8 };

        int[] arr = { 18, 25, 16, 56, 63, 14, 21, 8, 22};
        // todo 定义函数
        quickSort(arr,0,arr.length - 1);
       for (int i = 0; i < arr.length ; i++) {
             System.out.println(arr[i]);
        }


    }

    private static void quickSort(int[] arr,int low,int high){
        //第一次排序，以第一位开始，返回下标
        int index =getIndex(arr,low,high);
        if(low < high){
            //左侧
            quickSort(arr,low,index-1);

            //右侧
            quickSort(arr,index+1,high);
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
