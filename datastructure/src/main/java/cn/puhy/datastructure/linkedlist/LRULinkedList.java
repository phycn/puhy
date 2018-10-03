package cn.puhy.datastructure.linkedlist;

/**
 * @author PUHY
 * 2018-10-03 10:02
 */
public class LRULinkedList {

    //头节点
    private Node first = null;
    private int size;
    private int length = 0;

    public LRULinkedList() {
        this.size = 16;
    }

    public LRULinkedList(int size) {
        this.size = size;
    }

    /**
     * 插入节点到链表头部
     *
     * @param data
     */
    public void insert(long data) {
        Node node = new Node(data);
        //原头节点变为新头节点的下一节点
        node.next = first;
        //新节点变为头节点
        first = node;
        // 超过容量删除尾节点
        if (++length > size) {
            remove();
        }
    }

    /**
     * 删除尾节点
     *
     * @return
     */
    public Node remove() {
        Node node = first.next;
        Node curr = first;
        Node delete;
        while (node.next != null) {
            curr = node;
            node = node.next;
        }
        curr.next = null;
        delete = node;
        return delete;
    }

    /**
     * 获取指定位置节点，再变为头结点
     * @param index
     * @return
     */
    public Node get(int index) {

        Node curr = null;
        if (index == 0) {
            return first;
        } else if (index > 0) {
            int num = 0;
            Node previous = first;
            //找到指定位置前一节点
            while (index - 1 > num) {
                previous = previous.next;
                num++;
            }
            //指定位置节点
            curr = previous.next;
            //指定位置的前一节点的下一节点变为原指定位置节点的下一节点
            previous.next = curr.next;
            //指定位置节点变为头结点，下一节点为原头结点
            curr.next = first;
            //重新设置头结点
            first = curr;
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

    public static void main(String[] args) {
        LRULinkedList list = new LRULinkedList(4);
        list.insert(0);
        list.insert(1);
        list.insert(2);
        list.insert(3);
        list.insert(4);
        list.display();

        System.out.println(list.get(2));
        System.out.println(list.get(3));
        list.display();

//        list.remove();
//
//        list.display();
//        list.insert(0);
//        list.display();
    }
}
