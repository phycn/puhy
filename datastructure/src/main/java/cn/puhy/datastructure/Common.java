package cn.puhy.datastructure;

import java.util.Random;

/**
 * @author puhongyu
 * 2018/3/10 10:32
 */
public class Common {

    /**
     * 生成随机数数组
     *
     * @return
     */
    public static int[] generateArray() {

        Random random = new Random();
        int[] array = new int[10];
        for (int i = 0; i < 10; i++) {
            array[i] = random.nextInt(100);
        }
        return array;
    }

    /**
     * 打印数组
     * @param arr
     */
    public static void display(int[] arr) {
        System.out.print("[");
        for (int anArr : arr) {
            System.out.print(anArr + " ");
        }
        System.out.println("]");
    }
}
