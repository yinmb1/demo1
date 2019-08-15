package yy.demo.demo1.base.algorithm.Test02;

/**
 * @author yinmb
 * @Date 2019/5/5 18:42:50
 */
public class Test03 {
    //给出一个排序好的数组和一个数，求数组中连续元素的和等于所给数的子数组

    public void test(){
        int[] num = {1,2,2,3,4,5,6,7,8,9};
        int sum = 7;
        findSum(num,sum);
    }

    public void findSum(int[] num,int sum){
        int left=0;
        int right=0;

        for(int i=0;i<num.length;i++){
            int curSum = 0;
            left = i;
            right = i;
            while(curSum<sum){
                curSum += num[right++];
            }
            if(curSum==sum){
                for(int j=left;j<right;j++){
                    System.out.print(num[j]+" ");
                }
                System.out.println();
            }
        }
    }

    public static void main(String[] args) {
        Test03 test03 = new Test03();
        test03.test();
    }

}
