package yy.demo.demo1.base.algorithm.search;


import sun.reflect.generics.tree.Tree;

/**
 * @author yinmb
 * @Date 2019/7/25 18:19:02
 */
public class TreeSearch {
    /**
     * 每一个节点的值
     */
    public Integer data;
    public static TreeSearch root;//根节点(有且仅有一个)
    public TreeSearch father;//父节点
    public TreeSearch leftSon;//左子节点
    public TreeSearch rightSon;//右子节点

    /**
     *  左树是否为空
     */
    public boolean hasLeftSon(){
        return leftSon!=null;
    }
    /**
     * 右树是否为空
     */
    public boolean hasRightSon(){
        return rightSon!=null;
    }

    /**
     * 插入节点
     */
    public void insert(Integer data,TreeSearch father){
        /**
         * 思想：先让data和root中的值进行比较，大于0插入右边，小于0插入左边，计划使用递归思想
         */
        //等于root.data
        if(data.compareTo(father.data)==0){
            return;
        }
        //大于root.data
        if(data.compareTo(father.data)>0){
            //父节点没有右节点
            if(!father.hasRightSon()){
                father.rightSon = new TreeSearch();//生成一个右节点
                father.rightSon.data=data;//给右节点赋值
                father.rightSon.father=father;//指定右节点的父亲是谁
            }else{
                insert(data,father.rightSon);
            }
        }

        //小于同上
        if(data.compareTo(father.data)<0){
            //父节点没有左节点
            if(!father.hasLeftSon()){
                father.leftSon = new TreeSearch();//生成一个右节点
                father.leftSon.data=data;//给右节点赋值
                father.leftSon.father=father;//指定右节点的父亲是谁
            }else{
                insert(data,father.leftSon);
            }
        }
    }




    /**
     * 总体插入操作
     * 1.判断是否有树根，没有的话将数据添加到树根里
     * 2.有树根调用insert的重载方法，判断插入到左son还是右son
     * @param data
     */
    public void insert(Integer data){
        if(root==null){
            root = new TreeSearch();
            root.data=data;
            return;
        }else{
            insert(data,root);
        }
    }





    public static void main(String[] args) {
        TreeSearch tt = new TreeSearch();
        TreeSearch tree = new TreeSearch();
        tree.insert(5);
        tree.insert(2);
        tree.insert(3);
        tree.insert(1);
        tree.insert(8);
        tree.insert(3);
        tt.outPutTree(tree.root);
        tt.getMinValue(tree.root);
        tt.getMaxValue(tree.root);
    }
    //遍历树中的集合
    public void outPutTree(TreeSearch tree){
        System.out.print(tree.data+" ");
        if(tree.hasLeftSon()){
            outPutTree(tree.leftSon);
        }
        if(tree.hasRightSon()){
            outPutTree(tree.rightSon);
        }
    }
    //找出树中最小的值
    public void getMinValue(TreeSearch tree){
        if(tree.hasLeftSon()){
            getMinValue(tree.leftSon);
        }else{
            System.out.println("最小值"+tree.data);
        }
    }

    //找出树中最大的值
    public void getMaxValue(TreeSearch tree){
        if(tree.hasRightSon()){
            getMaxValue(tree.rightSon);
        }else{
            System.out.println("最大值"+tree.data);
        }
    }

}
