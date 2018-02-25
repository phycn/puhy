package cn.puhy.datastructure.sort;

/**
 * 冒泡排序
 * 时间复杂度：n²
 *
 * @author PUHY
 * 2018-02-25 11:31
 */
public class BuddleSort {

    /**
     * 排序
     *
     * @param arr
     */
    private static void sort(long[] arr) {
        int length = arr.length;
        for (int i = 0; i < length - 1; i++) {
            for (int j = length - 1; j > i; j--) {
                //前面一个数大于后面的就做交换
                if (arr[j] < arr[j - 1]) {
                    long temp = arr[j - 1];
                    arr[j - 1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }

    private static void display(long[] arr) {
        System.out.print("冒泡排序[");
        for (long anArr : arr) {
            System.out.print(anArr + " ");
        }
        System.out.println("]");
    }

    public static void main(String[] args) {
        long[] arr = {99, 10, 8, 19, 5, 2, 1, 22, 13};
        sort(arr);
        display(arr);
    }
}
