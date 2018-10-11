package phy.function;

import java.util.function.UnaryOperator;

/**
 * UnaryOperator<T> 一元函数，Function的子类，输入输出类型相同
 *
 * @author puhongyu
 * 2018/10/11 09:51
 */
public class MyUnaryOperator {
    public static void main(String[] args) {
        UnaryOperator<String> unaryOperator = str -> str.substring(1);
        System.out.println(unaryOperator.apply("puhongyu"));
    }
}
