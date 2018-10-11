package phy.function;

import java.util.function.BinaryOperator;

/**
 * BinaryOperator<T> 二元函数，输入输出类型相同
 *
 * @author puhongyu
 * 2018/10/11 10:12
 */
public class MyBinaryOperator {
    public static void main(String[] args) {
        BinaryOperator<Integer> binaryOperator = (a, b) -> a * b;
        System.out.println(binaryOperator.apply(3, 6));
    }
}
