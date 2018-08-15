package cn.puhy.jvm;

import java.util.ArrayList;
import java.util.List;

/**
 * 堆内存溢出
 * -Xmx16M -Xms16M
 *
 * @author puhongyu
 * 2018/8/15 07:48
 */
public class MemOverflow {
    public static void main(String[] args) {
        List<byte[]> list = new ArrayList<>();
        while (true) {
            list.add(new byte[1 * 1024 * 1024]);
        }
    }
}
