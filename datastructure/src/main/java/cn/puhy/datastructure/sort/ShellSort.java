package cn.puhy.datastructure.sort;

/**
 * 希尔排序
 * 主要是增量的选取
 * shell增量：n = n/2，n初始为数组长度
 * hibbard增量：n1 = 1, ni = 2 * n(i-1) + 1
 * knuth增量：n1 = 1; ni = 3 * n(i - 1) + 1
 *
 * @author puhongyu
 * 2018/3/4 11:00
 */
public class ShellSort {

    /**
     * 计算最大增量，用的knuth增量
     *
     * @param length 数组长度
     * @return
     */
    private static int getMaxIncrement(int length) {
        int maxIncrement = 1;
        while (maxIncrement * 3 + 1 < length) {
            maxIncrement = maxIncrement * 3 + 1;
        }
        return maxIncrement;
    }

    /**
     * 获取下一增量
     *
     * @param increment 当前增量
     * @return
     */
    private static int getNextIncrement(int increment) {
        return (increment - 1) / 3;
    }

    /**
     * 排序
     *
     * @param array
     */
    private static void sort(long[] array) {
        int length = array.length;
        //获取最大增量
        int increment = getMaxIncrement(length);
        while (increment > 0) {
            for (int i = increment; i < length; i++) {
                long temp = array[i];
                int j = i;
                //插入排序，跳跃increment长度的间隔
                //j > increment - 1是防止j - increment小于0的情况
                while (j > increment - 1 && array[j - increment] > temp) {
                    //大的值后移
                    array[j] = array[j - increment];
                    j -= increment;
                }
                array[j] = temp;
            }
            increment = getNextIncrement(increment);
        }
    }

    private static void display(long[] arr) {
        System.out.print("希尔排序[");
        for (long anArr : arr) {
            System.out.print(anArr + " ");
        }
        System.out.println("]");
    }

    public static void main(String[] args) {
        long[] arr = {99, 10, 8, 19, 5, 2, 1, 22, 13, 0};
        sort(arr);
        display(arr);
    }
}
