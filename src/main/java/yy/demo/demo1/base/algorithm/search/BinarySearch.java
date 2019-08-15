package yy.demo.demo1.base.algorithm.search;

/**
 * @author yinmb
 * @Date 2019/7/24 09:13:24
 */
public class BinarySearch {

    /**
     * 折半查找
     * @param a
     * @param value
     * @return
     */
    int binarySearch(int a[], int value) {
        int n = a.length;
        int low = 0;
        int high = n - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (a[mid] == value) {
                return mid;
            } else if (a[mid] > value) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }

    /**
     * 递归版本
     * @param a
     * @param value
     * @param low
     * @param high
     * @return
     */
    int binarySearch2(int a[], int value, int low, int high){
        int mid = low + (high - low)/2;
        if(a[mid] == value){
            return mid;
        }
        else if(a[mid] > value){
            return binarySearch2(a,value,low,mid - 1);
        }else{
            return binarySearch2(a,value,mid + 1,high);
        }
    }

    public static void main(String[] args) {
        BinarySearch binarySearch = new BinarySearch();
        binarySearch.binarySearch(new int[11],11);
        binarySearch.binarySearch2(new int[11],11,0,10);
    }
}
