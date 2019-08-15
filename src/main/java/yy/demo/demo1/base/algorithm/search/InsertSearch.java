package yy.demo.demo1.base.algorithm.search;

/**
 * @author yinmb
 * @Date 2019/7/25 09:53:41
 */
public class InsertSearch {

    public int insertSearch(int[] a, int n, int key) {
        int low, high, mid;
        low = 0;
        high = n - 1;
        while (low <= high) {
            mid = low + (key - a[low]) / (a[high] - a[low]) * (high - low);
            if (a[mid] < key) {
                low = mid + 1;
            } else if (a[mid] > key) {
                high = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }


    public static void main(String[] args) {
        InsertSearch binarySearch = new InsertSearch();
        binarySearch.insertSearch(new int[11],11,0);

    }
}
