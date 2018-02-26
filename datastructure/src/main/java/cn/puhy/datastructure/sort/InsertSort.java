package cn.puhy.datastructure.sort;

/**
 * 插入排序
 * 时间复杂度：n²
 *
 * @author PUHY
 * 2018-02-25 14:08
 */
public class InsertSort {

    private static void sort(long[] arr) {

        int length = arr.length;
        for (int i = 1; i < length; i++) {
            int j = i;
            long temp = arr[i];

            while (j > 0 && arr[j - 1] > temp) {
                //后移
                arr[j] = arr[j - 1];
                j--;
            }
            //腾出来的位置
            arr[j] = temp;
        }
    }

    private static void display(long[] arr) {
        System.out.print("插入排序[");
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
