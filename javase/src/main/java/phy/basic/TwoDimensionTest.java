package phy.basic;

public class TwoDimensionTest {

    public static void main(String ... args) {
        
        //定义一个二维数组
        int[][] a;
        //把a当做一维数组进行初始化，初始化a为一个长度为4的数组
        //a数组的元素又是一维数组
        a = new int[4][];
        
        for(int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
        
        //初始化a数组的第一个元素
        a[0] = new int[2];
        //为a数组的第一个元素所指数组的第二个元素赋值
        a[0][1] = 6;
        
        //遍历a数组的第一个元素
        for(int i = 0; i < a[0].length; i++) {
            
            System.out.println(a[0][i]);
        }
    }
}
