package cn.puhy.datastructure.linkedlist;

/**
 * 单链表
 *
 * @author puhongyu
 * 2018/2/27 21:24
 */
public class MyLinkedList {

    //头节点
    private Node first = null;

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
     * @param data
     */
    public void insertFirst(long data) {
        Node node = new Node(data);
        //原头节点变为新头节点的下一节点
        node.next = first;
        //新节点变为头节点
        first = node;
        length++;
    }

    /**
     * 链表反转，只是单纯地输出
     */
    public void reversalList() {
        reversal(first);
    }

    private void reversal(Node node) {
        if (node.next == null) {
            System.out.print(node + " ");
        } else {
            reversal(node.next);
            System.out.print(node + " ");
        }
    }

    // 检测环，快慢指针
    public boolean checkLoop(Node node) {
        if (node == null) {
            return false;
        }

        Node fast = node.next;
        Node slow = node;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (slow == fast) {
                return true;
            }
        }

        return false;
    }

    /**
     * 合并两个有序链表
     *
     * @param one
     * @param two
     * @return
     */
    public Node mergeSortedLists(Node one, Node two) {
        if (one == null) {
            return two;
        }
        if (two == null) {
            return one;
        }

        Node onePointer = one;
        Node twoPointer = two;
        Node head;
        if (one.data < two.data) {
            head = one;
            onePointer = onePointer.next;
        } else {
            head = two;
            twoPointer = twoPointer.next;
        }

        Node newPointer = head;
        while (onePointer != null && twoPointer != null) {
            if (onePointer.data < twoPointer.data) {
                newPointer.next = onePointer;
                onePointer = onePointer.next;
            } else {
                newPointer.next = twoPointer;
                twoPointer = twoPointer.next;
            }
            newPointer = newPointer.next;
        }

        // 尾巴处理，就是其中一个链表已完，另外一个还有
        if (onePointer != null) {
            newPointer.next = onePointer;
        } else {
            newPointer.next = twoPointer;
        }

        return head;
    }

    /**
     * 删除倒数第k个元素
     *
     * @param k
     * @return
     */
    public Node deleteLastKth(int k) {
        int count = length - k;
        Node delete = first;
        for (int i = 0; i < count; i++) {
            delete = delete.next;
        }
        try {
            delete(count);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return delete;
    }

    /**
     * 找出中间节点
     *
     * @return
     */
    public Node findMiddleNode(Node node) {
        Node fast = node;
        Node slow = node;
        while (fast.next.next != null && slow.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
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
            //指定位置为新节点
            previous.next = newNode;
            length++;
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
    public Node delete(int index) throws Exception {

        Node curr = null;
        if (index == 0) {
            deleteFirst();
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

            length--;
        } else {
            throw new Exception("非法数值");
        }
        return curr;
    }

    /**
     * 删除头节点
     *
     * @return
     */
    public Node deleteFirst() {
        //头节点变为它的下一个节点
        first = first.next;
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

    public static void main(String[] args) throws Exception {
        /*MyLinkedList linkedList = new MyLinkedList();
        linkedList.insertFirst(11);
        linkedList.insertFirst(10);
        linkedList.insertFirst(9);
        linkedList.insertFirst(66);

        linkedList.display();
        linkedList.deleteFirst();
        linkedList.display();

        linkedList.insert(88, 0);
        linkedList.insert(19, 2);
        linkedList.display();
        linkedList.delete(3);
        linkedList.display();

        System.out.println(linkedList.size());*/

        MyLinkedList linkedList = new MyLinkedList();
        linkedList.insertFirst(11);
        linkedList.insertFirst(10);
        linkedList.insertFirst(9);
        linkedList.insertFirst(66);
        linkedList.display();
        linkedList.deleteLastKth(2);
        linkedList.display();

//        linkedList.reversalList();
    }
}
