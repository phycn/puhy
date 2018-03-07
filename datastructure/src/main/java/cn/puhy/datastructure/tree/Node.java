package cn.puhy.datastructure.tree;

/**
 * 二叉树节点
 *
 * @author puhongyu
 * 2018/3/5 19:55
 */
public class Node {

    //数据项
    public int data;
    //左子节点
    public Node leftChild;
    //右子节点
    public Node rightChild;

    public Node(int data) {
        this.data = data;
    }
}
