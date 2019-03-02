package phy.jdk8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @author puhongyu
 * 2019-02-28 23:18
 */
public class StreamDemo2 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();

        // 从集合创建
        list.stream();
        list.parallelStream();

        // 从数组创建
        Arrays.stream(new int[]{2, 3, 5});

        // 创建数字流
        IntStream.of(1, 2, 3);
        // 创建1-5的流
        IntStream.rangeClosed(1, 5).forEach(System.out::println);

        // 使用random创建一个无限流
        new Random().ints().limit(10);
        Random random = new Random();

        // 自己产生流
        Stream.generate(random::nextInt).limit(20);
    }
}
