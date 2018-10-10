package phy.function;

import java.util.ArrayList;
import java.util.function.Consumer;

/**
 * Consumer<T> 消费数据T
 * @author puhongyu
 * 2018/10/10 17:35
 */
public class MyConsumer {
    public static void main(String[] args) {
        Consumer<ArrayList<String>> consumer = list -> list.add("phy2533");
        ArrayList<String> list = new ArrayList<>();
        consumer.accept(list);
        System.out.println(list.size());
    }
}
