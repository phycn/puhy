package cn.puhy.leetcode.array;

import java.util.Arrays;

/**
 * 给定一个非负整数组成的非空数组，在该数的基础上加一，返回一个新的数组。
 * 最高位数字存放在数组的首位， 数组中每个元素只存储一个数字。
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 *
 * @author puhongyu
 * 2018/8/9 13:24
 */
public class PlusOne {

    public static int[] plusOne(int[] digits) {
        int length = digits.length;
        for (int i = 0; i < length; i++) {
            if (digits[i] < 0 || digits[i] > 9) {
                return null;
            }
        }

        for (int i = length - 1; i >= 0; i--) {
            int num = digits[i];
            if (num < 9) {
                digits[i]++;
                break;
            } else {
                digits[i] = 0;
                //溢出处理，比如9，9，9这种
                if (i == 0) {
                    int[] newArr = new int[length + 1];
                    //拷贝原数组到新数组
                    System.arraycopy(digits, 0, newArr, 1, length);
                    //新数组首位为1
                    newArr[0] = 1;
                    return newArr;
                }
            }
        }

        return digits;
    }

    public static void main(String[] args) {
        int[] nums = {9, 9, 9};
        System.out.println(Arrays.toString(plusOne(nums)));
    }
}
