package cn.puhy.datastructure.sort;

/**
 * 快速排序
 *
 * @author puhongyu
 * 2018/3/4 17:33
 */
public class QuickSort {

    private static void sort(long[] array, int initStart, int initEnd) {
        if (initEnd <= initStart) {
            return;
        }
        int start = initStart;
        int end = initEnd + 1;
        //设置关键值
        long key = array[initStart];
        while (start < end) {
            //从左开始找大于关键值的值，找到就跳出循环
            while (array[++start] < key) ;
            //从右开始找小于关键值的值，找到就跳出循环
            while (array[--end] > key) ;
            //跳出循环
            if (start >= end) {
                break;
            }
            //交换
            long temp = array[end];
            array[end] = array[start];
            array[start] = temp;
        }
        //交换关键值，这样关键值左边都是小于关键值的值，右边都是大于关键值的值
        long temp = array[end];
        array[end] = key;
        array[initStart] = temp;

        //递归调用对左边再次进行快速排序
        sort(array, initStart, end - 1);
        //递归调用对右边再次进行快速排序
        sort(array, end + 1, initEnd);
    }

    private static void display(long[] arr) {
        System.out.print("快速排序[");
        for (long anArr : arr) {
            System.out.print(anArr + " ");
        }
        System.out.println("]");
    }

    public static void main(String[] args) {
        long[] arr = {86, 83, 48, 64, 24, 15, 76, 98, 17, 65};
        sort(arr, 0, arr.length - 1);
        display(arr);
    }
}
