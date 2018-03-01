package cn.puhy.datastructure.linkedlist;

/**
 * 双向链表
 *
 * @author puhongyu
 * 2018/2/28 22:40
 */
public class MyDoubleLinkedList {

    //头节点
    private Node first = null;
    //尾节点
    private Node last = null;
    //链表长度
    private int length = 0;

    /**
     * 获取链表长度
     *
     * @return
     */
    public int size() {
        return length;
    }

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
        } else {
            //当前头节点的前一节点变为新增的节点
            first.previous = node;
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
            //新增节点的前一节点为当前尾节点
            node.previous = last;
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
        //要删除的节点
        Node temp = first;
        //新头节点变为原头节点的下一个节点
        first = first.next;
        //头节点的下一节点为空时，表示整个链表都为空，尾节点也要同时为空
        if (first == null) {
            last = null;
        } else {
            //头节点的前一节点设置为空
            first.previous = null;
        }
        length--;
        return temp;
    }

    /**
     * 删除尾节点
     *
     * @return
     */
    public Node deleteLast() {
        //要删除的节点
        Node temp = last;
        //新尾节点变为原尾节点的前一节点
        last = last.previous;
        //尾节点的前一节点为空时，表示整个链表都为空，头节点也要同时为空
        if (last == null) {
            first = null;
        } else {
            //尾节点的下一节点设置为空
            last.next = null;
        }
        length--;
        return temp;
    }

    /**
     * 在指定位置插入节点
     *
     * @param index
     */
    public void insert(long data, int index) throws Exception {

        if (index == 0) {
            insertFirst(data);
        } else if (index > 0) {
            if (index == length - 1) {
                insertLast(data);
            } else {
                int num = 0;
                Node previous = first;
                //找到指定位置前一节点
                while (index - 1 > num) {
                    previous = previous.next;
                    num++;
                }
                Node newNode = new Node(data);
                //新节点的下一节点就是当前指定位置的节点
                newNode.next = previous.next;
                //新节点的前一节点为指定位置前一节点
                newNode.previous = previous;
                //原指定位置节点的前一节点为新节点
                previous.next.previous = newNode;
                //指定位置为新节点
                previous.next = newNode;
                length++;
            }
        } else {
            throw new Exception("非法数值");
        }
    }

    /**
     * 删除指定位置节点
     *
     * @param index
     * @return
     */
    public Node delete(int index) {

        Node curr = null;
        if (index == 0) {
            deleteFirst();
            curr = first;
        } else if (index == length - 1) {
            deleteLast();
            curr = last;
        } else {
            int num = 0;
            curr = first;
            //找出指定位置节点
            while (num < index) {
                curr = curr.next;
                num++;
            }
            //指定位置的前一节点的下一节点变为指定位置的下一节点
            curr.previous.next = curr.next;
            //指定位置的下一节点的前一节点变为指定位置的前一节点
            curr.next.previous = curr.previous;
            length--;
        }
        return curr;
    }

    public void display() {
        Node current = first;
        while (current != null) {
            current.display();
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String[] args) throws Exception {
        MyDoubleLinkedList doubleLinkedList = new MyDoubleLinkedList();
        doubleLinkedList.insertFirst(11);
        doubleLinkedList.insertFirst(22);
        doubleLinkedList.insertFirst(33);
        doubleLinkedList.display();
        System.out.println(doubleLinkedList.size());

        doubleLinkedList.insertLast(12);
        doubleLinkedList.insertLast(61);
        doubleLinkedList.display();
        System.out.println(doubleLinkedList.size());

        doubleLinkedList.deleteFirst();
        doubleLinkedList.display();
        System.out.println(doubleLinkedList.size());

        doubleLinkedList.deleteLast();
        doubleLinkedList.display();
        System.out.println(doubleLinkedList.size());

        doubleLinkedList.insert(16, 0);
        doubleLinkedList.display();
        System.out.println(doubleLinkedList.size());

        doubleLinkedList.deleteLast();
        doubleLinkedList.display();
        System.out.println(doubleLinkedList.size());

        doubleLinkedList.delete(1);
        doubleLinkedList.display();
        System.out.println(doubleLinkedList.size());

        doubleLinkedList.deleteFirst();
        doubleLinkedList.display();
        System.out.println(doubleLinkedList.size());

        doubleLinkedList.deleteFirst();
        doubleLinkedList.display();
        System.out.println(doubleLinkedList.size());
    }
}
