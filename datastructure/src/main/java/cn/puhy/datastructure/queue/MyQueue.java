package cn.puhy.datastructure.queue;

/**
 * 循环队列
 *
 * @author puhongyu
 * 2018/2/26 21:25
 */
public class MyQueue {
    private long[] arr;
    //对头
    private int front = 0;
    //队尾
    private int end = -1;
    //有效数据总数
    private int count;

    public MyQueue() {
        arr = new long[4];
    }

    /**
     * 添加数据，从队尾加入
     *
     * @param value
     */
    public void insert(long value) {
        //重置
        if (end == arr.length - 1) {
            end = -1;
        }
        arr[++end] = value;
        //总数加1
        count++;
    }

    /**
     * 删除数据，从队头删除
     *
     * @return
     */
    public long delete() {
        long value = arr[front++];
        //重置
        if (front == arr.length) {
            front = 0;
        }
        //总数减1
        count--;
        return value;
    }

    /**
     * 查看数据
     *
     * @return
     */
    public long peek() {
        return arr[front];
    }

    public static void main(String[] args) {
        MyQueue queue = new MyQueue();
        queue.insert(12);
        queue.insert(8);
        queue.insert(16);
        queue.insert(22);

        System.out.println(queue.peek());
        //队列满了，插入的位置是第一个
        queue.insert(33);
        System.out.println(queue.peek());
//        queue.delete();
//        System.out.println(queue.peek());
    }
}
