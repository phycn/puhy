package cn.puhy.datastructure.stack;

/**
 * @author puhongyu
 * 2018/2/26 20:55
 */
public class MyStack {

    private long[] arr;
    private int top = -1;

    public MyStack() {
        arr = new long[20];
    }

    /**
     * 添加数据
     *
     * @param value
     */
    public void push(long value) {
        arr[++top] = value;
    }

    /**
     * 弹出数据
     *
     * @return
     */
    public long pop() {
        return arr[top--];
    }

    /**
     * 查看数据
     *
     * @return
     */
    public long peek() {
        return arr[top];
    }

    public static void main(String[] args) {
        MyStack stack = new MyStack();
        stack.push(10);
        stack.push(9);
        stack.push(16);

        stack.pop();
        System.out.println(stack.peek());
    }
}
