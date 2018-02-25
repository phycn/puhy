package cn.puhy.datastructure.sort;

/**
 * 选择排序
 * 时间复杂度：n²
 *
 * @author PUHY
 * 2018-02-25 13:30
 */
public class SelectionSort {

    private static void sort(long[] arr) {

        int length = arr.length;
        for (int i = 0; i < length - 1; i++) {
            int minIndex = i;
            //找出最小值的索引
            for (int j = i + 1; j < length; j++) {
                if (arr[minIndex] > arr[j]) {
                    minIndex = j;
                }
            }

            //将最小值换到前面
            long temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }
    }

    private static void display(long[] arr) {
        System.out.print("选择排序[");
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
