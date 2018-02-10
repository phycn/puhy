package phy.basic;

import java.util.Arrays;
import java.util.function.IntBinaryOperator;
import java.util.function.IntUnaryOperator;

public class ArraysTest2 {

    public static void main(String[] args) {

        int[] arr1 = new int[]{3, -2, 8, -13, 5, 0};
        //与sort相似，增加并行能力，利用多CPU
        Arrays.parallelSort(arr1);

        int[] arr2 = new int[]{2, 3, 7, 5, 2};
        Arrays.parallelPrefix(arr2, new IntBinaryOperator() {

            //left代表数组中前一个索引处的元素，计算第一个元素时为1
            //right代表当前索引处的元素
            @Override
            public int applyAsInt(int left, int right) {

                return left + right;
            }
        });
        System.out.println(Arrays.toString(arr2));

        int[] arr3 = new int[5];
        Arrays.parallelSetAll(arr3, new IntUnaryOperator() {

            //operand代表正在计算的元素索引
            @Override
            public int applyAsInt(int operand) {

                return operand + 3;
            }
        });
        System.out.println(Arrays.toString(arr3));
    }
}
