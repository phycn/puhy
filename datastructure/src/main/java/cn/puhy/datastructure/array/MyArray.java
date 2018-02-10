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
     * 有序添加
     * @param value
     */
    public void sortedInsert(long value) {

    }

    /**
     * 显示数据
     */
    public void display() {
        System.out.print("[");
        for (int i = 0; i < element; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println("]");
    }

    /**
     * 查找数据索引
     *
     * @param value
     */
    public int search(long value) {
        int index = -1;
        for (int i = 0; i < element; i++) {
            if (array[i] == value) {
                index = i;
            }
        }
        return index;
    }

    /**
     * 根据索引查询数据
     *
     * @param index
     * @return
     */
    public long get(int index) {

        if (index >= element || index < 0) {
            throw new ArrayIndexOutOfBoundsException();
        }
        return array[index];
    }

    /**
     * 删除指定索引的数据
     *
     * @param index
     */
    public void delete(int index) {
        if (index >= element || index < 0) {
            throw new ArrayIndexOutOfBoundsException();
        }
        //将后面一个的值赋给前一个
        for (; index < element; index++) {
            array[index] = array[index + 1];
        }
        element--;
    }

    /**
     * 更新指定索引位置数据
     *
     * @param index
     * @param newValue
     */
    public void update(int index, long newValue) {
        if (index >= element || index < 0) {
            throw new ArrayIndexOutOfBoundsException();
        }
        array[index] = newValue;
    }

    public static void main(String[] args) {
        MyArray m = new MyArray();
        m.insert(1000);
        m.insert(1001);
        m.insert(999);
        m.insert(1234);
        m.insert(987);

        m.display();
        System.out.println(m.search(999));

        System.out.println(m.get(1));

        m.delete(1);
        m.display();

        m.update(1, 998);
        m.display();
    }
}
