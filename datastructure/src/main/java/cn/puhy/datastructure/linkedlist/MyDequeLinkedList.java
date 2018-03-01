package cn.puhy.datastructure.linkedlist;

/**
 * 双端链表
 *
 * @author puhongyu
 * 2018/2/28 21:37
 */
public class MyDequeLinkedList {

    //头节点
    private Node first = null;
    //尾节点
    private Node last = null;

    private int length = 0;

    /**
     * 判断是否为空
     *
     * @return
     */
    public boolean isEmpty() {
        return first == null;
    }

    /**
     * 在头节点位置插入
     *
     * @param data
     */
    public void insertFirst(long data) {
        Node node = new Node(data);
        //第一次插入时将节点设置为尾节点
        if (isEmpty()) {
            last = node;
        }
        //原头节点变为新头节点的下一节点
        node.next = first;
        //新节点变为头节点
        first = node;
        length++;
    }

    /**
     * 在尾节点位置插入
     *
     * @param data
     */
    public void insertLast(long data) {
        Node node = new Node(data);
        //第一次插入时将节点设置为头节点
        if (isEmpty()) {
            first = node;
        } else {
            //当前尾节点的下一节点为新增的节点
            last.next = node;
        }
        //新节点变为尾节点
        last = node;
        length++;
    }

    /**
     * 删除头节点
     *
     * @return
     */
    public Node deleteFirst() {
        //头节点变为它的下一个节点
        first = first.next;
        //头节点的下一节点为空时，表示整个链表都为空，尾节点也要同时为空
        if (first == null) {
            last = null;
        }
        length--;
        return first;
    }

    public void display() {
        Node current = first;
        while (current != null) {
            current.display();
            current = current.next;
        }
        System.out.println();
    }
    
    public static void main(String[] args) {
        MyDequeLinkedList dequeLinkedList = new MyDequeLinkedList();
        dequeLinkedList.insertFirst(9);
        dequeLinkedList.insertFirst(12);
        dequeLinkedList.insertLast(8);
        dequeLinkedList.insertLast(11);
        dequeLinkedList.insertFirst(6);
        dequeLinkedList.display();
    }
}
