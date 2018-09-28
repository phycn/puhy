package phy.jdk11;

import java.util.List;

/**
 * @author puhongyu
 * 2018/9/28 10:09
 */
public class CollectionReinforce {
    public static void main(String[] args) {
        // 使用of和copyOf创建的集合为不可变集合，不能进行添加、删除、替换、排序
        var list = List.of("phy", "puhy", "puhongyu");
        var copyList = List.copyOf(list);
        System.out.println(copyList == list);
    }
}
