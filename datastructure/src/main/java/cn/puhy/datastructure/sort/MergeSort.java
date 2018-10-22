package cn.puhy.datastructure.sort;

/**
 * 归并排序
 *
 * @author puhongyu
 * 2018/10/17 10:11
 */
public class MergeSort {

    private static void sort(long[] array) {
        long[] newArr = sortArray(array);
        display(newArr);
    }

    private static long[] sortArray(long[] array) {
        int len = array.length;
        if (len == 1) {
            return array;
        }
        int mid = (len - 1) / 2;
        long[] leftArr = new long[mid + 1];
        long[] rightArr = new long[len - mid - 1];
        System.arraycopy(array, 0, leftArr, 0, leftArr.length);
        System.arraycopy(array, mid + 1, rightArr, 0, rightArr.length);
        return merge(sortArray(leftArr), sortArray(rightArr));
    }

    private static long[] merge(long[] leftArr, long[] rightArr) {
        int i = 0, j = 0, k = 0;
        int leftLen = leftArr.length;
        int rightLen = rightArr.length;
        long[] mergeArr = new long[leftLen + rightLen];

        while (i < leftLen && j < rightLen) {
            if (leftArr[i] < rightArr[j]) {
                mergeArr[k++] = leftArr[i++];
            } else {
                mergeArr[k++] = rightArr[j++];
            }
        }

        if (i < leftLen) {
            System.arraycopy(leftArr, i, mergeArr, k, leftLen - i);
        } else if (j < rightLen) {
            System.arraycopy(rightArr, j, mergeArr, k, rightLen - j);
        }

        return mergeArr;
    }

    private static void display(long[] arr) {
        System.out.print("归并排序[");
        for (long anArr : arr) {
            System.out.print(anArr + " ");
        }
        System.out.println("]");
    }

    public static void main(String[] args) {
        long[] arr = {99, 10, 8, 19, 5, 2, 1, 22, 4};
        sort(arr);
    }
}
