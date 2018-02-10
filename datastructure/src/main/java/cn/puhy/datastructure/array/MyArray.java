package cn.puhy.datastructure.array;

public class MyArray {

    private long[] array;
    private int element = 0;


    public MyArray() {
        array = new long[50];
    }

    public MyArray(int length) {
        array = new long[length];
    }

    /**
     * 添加数据
     *
     * @param value
     */
    public void insert(long value) {
        array[element] = value;
        element++;
    }

    /**
     * 显示数据
     */
    public void display() {
        for (int i = 0; i < element; i++) {
            System.out.println(array[i]);
        }
    }
    
    public static void main(String[] args) {
        MyArray m = new MyArray();
        m.insert(1000);
        m.insert(1001);

        m.display();
    }
}
