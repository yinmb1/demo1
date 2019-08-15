package yy.demo.demo1.modes.composite;

import java.util.Enumeration;
import java.util.Vector;

/**
 * @author yinmb
 * @Date 2019/1/30 10:29:12
 */
public class TreeNode {
    private String name;
    private String  parentName;
    private Vector<TreeNode> children = new Vector<TreeNode>();

    public TreeNode(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getParent() {
        return this.getName();
    }

    public void setParent(String parent) {
        this.parentName = parent;
    }

    //添加孩子节点
    public void add(TreeNode node){
        children.add(node);
        node.setParent(getParent());
    }

    //删除孩子节点
    public void remove(TreeNode node){
        children.remove(node);
    }

    //取得孩子节点
    public Enumeration<TreeNode> getChildren(){
        return children.elements();
    }
}
