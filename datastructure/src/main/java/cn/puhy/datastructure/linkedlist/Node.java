package cn.puhy.datastructure.linkedlist;

/**
 * 链表节点
 *
 * @author puhongyu
 * 2018/2/27 21:23
 */
public class Node {
    //数据域
    public long data;
    //节点域，指向下一个节点
    public Node next;
    //前一个节点
    public Node previous;

    public Node(long data) {
        this.data = data;
    }

    public void display() {
        System.out.print(data + " ");
    }
}
