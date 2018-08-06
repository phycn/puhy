package cn.puhy.leetcode.array;

/**
 * 给定一个整数类型的数组 nums，请编写一个能够返回数组“中心索引”的方法。
 * 我们是这样定义数组中心索引的：数组中心索引的左侧所有元素相加的和等于右侧所有元素相加的和。
 * 如果数组不存在中心索引，那么我们应该返回 -1。如果数组有多个中心索引，那么我们应该返回最靠近左边的那一个。
 *
 * @author puhongyu
 * 2018/8/3 12:33
 */
public class CentralIndex {
    public static int pivotIndex(int[] nums) {
        int length = nums.length;
        for (int i = 1; i < length - 1; i++) {
            int left = 0;
            int right = 0;
            for (int j = 0; j < i; j++) {
                left += nums[j];
            }
            for (int k = i + 1; k < length; k++) {
                right += nums[k];
            }
            if (left == right) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {2, 9, 4, 7, 3, 20, 2};
        System.out.println(pivotIndex(nums));
    }
}
