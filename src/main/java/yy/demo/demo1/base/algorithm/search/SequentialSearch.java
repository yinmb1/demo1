package yy.demo.demo1.base.algorithm.search;

/**
 * 顺序查找
 * @author yinmb
 * @Date 2019/7/24 08:48:41
 */
public class SequentialSearch {

    public int sequenceSearch(int a[], int value){
        for(int i = 0; i < a.length; i++){
            if(a[i] == value){
                return i;
            }
        }
        return -1;
    }

    /**
     * 优化：每次循环都需要对i是否越界进行判断。因此可以设置一个哨兵
     * @param a
     * @param value
     * @return
     */
    public int sequenceSearch1(int a[], int value){
        int[] b = new int[a.length + 1];
        b[0] = value;
        for(int i = 0; i < a.length; i++){
            b[i + 1] = a[i];
        }
        int j = a.length;
        while(b[j] != value){
            j--;
        }
        return j;
    }

    public static void main(String[] args) {
        SequentialSearch sequentialSearch= new SequentialSearch();
        sequentialSearch.sequenceSearch(new int[12],11);
        sequentialSearch.sequenceSearch1(new int[12],11);
    }
}
