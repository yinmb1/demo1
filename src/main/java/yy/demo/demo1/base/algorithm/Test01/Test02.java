package yy.demo.demo1.base.algorithm.Test01;

/**
 * 创建数组遍历数组
 * @author yinmb
 * @Date 2019/4/30 17:20:19
 */
public class Test02 {
    public int[][] init(){
        int [][] aa =new int[10][10];
        int n = 4;
        int count = 1;
        for (int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                aa[i][j]=count;
                count++;
            }

        }
        System.out.println(aa.length);
        return aa;
    }

    public void sortGo(int[][] aa,int start,int end){
        if (end<0){
            return;
        }
        for(int i=start;i<=end;i++){
            System.out.println(aa[start][i]);
        }
        for(int i=start+1;i<=end;i++){
            System.out.println(aa[i][end]);
        }
        for(int i=end-1;i>start-1;i--){
            System.out.println(aa[end][i]);
        }
        for(int i=end-1;i>start;i--){
            System.out.println(aa[i][start]);
        }
        sortGo(aa,start+1,end-1);
    }

    public static void main(String[] args) {
        Test02 test02 = new Test02();
        test02.printArr3(test02.init());
        test02.sortGo(test02.init(),0,3);
    }


    //方法1
    public  void printArr1(int[][] arr) {
        for(int x=0; x<arr.length; x++) {
            for(int y=0; y<arr[x].length; y++) {
                System.out.print(arr[x][y]+" ");
            }
            System.out.println();
        }
    }

    //方法2
    public  void printArr2(int[][] arr) {
        //遍历二维数组中每一个一维数组
        for(int[] cells : arr) {
            //遍历一维数组中每一个元素
            for(int cell : cells) {
                System.out.print(cell+" ");
            }
            System.out.println();
        }
    }
    public void printArr3(int[][] aa){
        for (int[] aax:aa) {
            for (int aay : aax) {
                System.out.print(aay+" ");
            }
            System.out.println("");
        }
    }

}
