package phy.function;

import java.util.function.Supplier;

/**
 * Supplier<T> 提供一个数据
 *
 * @author puhongyu
 * 2018/10/10 17:47
 */
public class MySupplier {
    public static void main(String[] args) {
        Supplier<Integer> supplier = () -> 10 + 1;
        System.out.println(supplier.get());
    }
}
