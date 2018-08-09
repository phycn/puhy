package cn.puhy.leetcode.array;

/**
 * 在一个给定的数组nums中，总是存在一个最大元素 。
 * 查找数组中的最大元素是否至少是数组中每个其他数字的两倍。
 * 如果是，则返回最大元素的索引，否则返回-1。
 *
 * @author puhongyu
 * 2018/8/9 10:34
 */
public class DoubleNum {

    public static int dominantIndex(int[] nums) {
        int length = nums.length;
        //数组最大值索引
        int maxIndex = 0;
        //数组最大值
        int max = nums[maxIndex];
        for (int i = 1; i < length; i++) {
            if (nums[i] > max) {
                max = nums[i];
                maxIndex = i;
            }
        }

        for (int i = 0; i < length; i++) {
            //排除最大数本身
            if (i == maxIndex) {
                continue;
            }
            //为0的数跳过
            if (nums[i] == 0) {
                continue;
            }
            // max / nums[i] < 2 表示最大数不为当前数的两倍
            // max % nums[i] != 0 表示当前数不能被最大数整除
            if (max / nums[i] < 2) {
                return -1;
            }
        }

        return maxIndex;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,16,35,44,100,27,0};
        System.out.println(dominantIndex(arr));
    }
}
