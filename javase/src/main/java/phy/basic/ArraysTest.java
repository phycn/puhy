package phy.basic;

import java.util.Arrays;

public class ArraysTest {
  
    public static void main(String ... args) {
        
        int[] a1 = new int[]{3,4,5,6};
        int[] a2 = new int[]{3,4,5,6};
        
        //比较数组，长度相等，元素依次相等，将输出true
        System.out.println("a1和a2是否相等：" + Arrays.equals(a2, a1));
        
        //复制a2数组，生成一个长度为6的数组，
        int[] b = Arrays.copyOf(a2, 6);
        //输出数组，[3, 4, 5, 6, 0, 0]
        System.out.println(Arrays.toString(b));
        
        //讲b数组索引从2到4(不包括)的元素赋值为1
        Arrays.fill(b, 2, 4, 1);
        
        //排序
        Arrays.sort(b);
        System.out.println(Arrays.toString(b));
        
        //使用二分法查询3在数组中出现的索引，数组已经升序排列才会得到正确结果
        System.out.println(Arrays.binarySearch(b, 3));
    }
}
