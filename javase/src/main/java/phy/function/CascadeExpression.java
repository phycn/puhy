package phy.function;

import java.util.function.Function;

/**
 * 级联表达式和柯里化
 * 柯里化:把多个参数的函数转换为只有一个参数的函数
 * 柯里化的目的：函数标准化
 * 高阶函数：就是返回函数的函数
 */
public class CascadeExpression {
    public static void main(String[] args) {
        // 实现了x+y的级联表达式
        Function<Integer, Function<Integer, Integer>> function1 = x -> y -> x + y;
        System.out.println(function1.apply(5).apply(3));

        Function<Integer, Function<Integer, Function<Integer, Integer>>> function2 = x -> y -> z -> x * y * z;
        System.out.println(function2.apply(2).apply(3).apply(4));
    }
}
