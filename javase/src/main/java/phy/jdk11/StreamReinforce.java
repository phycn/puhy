package phy.jdk11;

import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author puhongyu
 * 2018/9/28 10:17
 */
public class StreamReinforce {
    public static void main(String[] args) {
        // 单个参数构造方法
        System.out.println(Stream.ofNullable(null).count());
        // 从开始计算，当 n < 3 时就截止
        System.out.println(Stream.of(1, 2, 3, 4, 5).takeWhile(n -> n < 3).collect(Collectors.toList()));
        // 从开始计算，当 n < 3 不成立时开始计算
        System.out.println(Stream.of(1, 2, 3, 4, 5).dropWhile(n -> n < 3).collect(Collectors.toList()));
    }
}
