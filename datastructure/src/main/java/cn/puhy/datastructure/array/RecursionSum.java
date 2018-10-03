package cn.puhy.datastructure.array;

/**
 * 递归求和
 *
 * @author PUHY
 * 2018-10-02 14:42
 */
public class RecursionSum {

    private static int sum(int[] array) {
        int length = array.length;
        if (length == 1) {
            return array[0];
        }
        int[] newArray = new int[length - 1];
        System.arraycopy(array, 1, newArray, 0, length - 1);
        return array[0] + sum(newArray);
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6};
        System.out.println(sum(array));
    }
}
