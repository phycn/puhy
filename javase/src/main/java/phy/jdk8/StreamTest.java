package phy.jdk8;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 流
 */
public class StreamTest {

    public static void main(String[] args) {

        List<Integer> myList = new ArrayList<>();
        myList.add(10);
        myList.add(12);
        myList.add(8);
        myList.add(9);
        myList.add(19);
        myList.add(4);
        myList.add(8);
        myList.add(8);

        Stream<Integer> myStream = myList.stream();
        //找出流中最小的元素
        Optional<Integer> minOp = myStream.min(Integer::compare);
        minOp.ifPresent((min) -> {
            System.out.println("最小数：" + min);
        });

        //重新获得流
        myStream = myList.stream();
        //找出流中最大的元素
        Optional<Integer> maxOp = myStream.max(Integer::compare);
        maxOp.ifPresent((max) -> {
            System.out.println("最大数：" + max);
        });

        //排序流
        Stream<Integer> sortedStream = myList.stream().sorted();
        //调用流中的每个元素
        sortedStream.forEach((n) -> System.out.println(n));
        System.out.println("--------");

        //过滤，获取流中的奇数
        Stream<Integer> oddVals = myList.stream().sorted().filter((n) -> (n % 2) == 1);
        oddVals.forEach(System.out::println);
        System.out.println("--------");

        //distinct去掉重复
        Stream<Integer> evenVals = myList.stream().filter(n -> (n % 2) == 0).distinct();
        evenVals.forEach(System.out::println);
        System.out.println("--------");

        //limit返回前两个元素
        Stream<Integer> limitVals = myList.stream().filter(n -> (n % 2) == 0).limit(2);
        limitVals.forEach(System.out::println);
        System.out.println("--------");

        //skip跳过前两个元素
        Stream<Integer> skipVals = myList.stream().filter(n -> (n % 2) == 0).skip(2);
        skipVals.forEach(System.out::println);
        System.out.println("--------");

        //缩减操作，就是将一个流缩减为一个值
        Optional<Integer> reduceOp = myList.stream().reduce((a, b) -> a + b);
        reduceOp.ifPresent((count1) -> {
            System.out.println("总和：" + count1);
        });
        System.out.println("--------");

        //累计操作，加法为0，乘法为1
        //与上面的相同
        int count2 = myList.stream().reduce(0, (a, b) -> a + b);
        System.out.println(count2);
        System.out.println("--------");

        //collect收集
        List<Integer> collect1 = myList.stream().filter(n -> (n % 2) == 0).collect(Collectors.toList());
        System.out.println(collect1);

        //第一个参数返回一个新的ArrayList，第二个参数为添加元素，第三个参数为合并
        List<Integer> collect2 = myList.stream().
                filter(n -> (n % 2) == 0)
                .collect(() -> new ArrayList<>(), (list, element)
                        -> list.add(element), (listA, listB) -> listA.addAll(listB));
    }
}
