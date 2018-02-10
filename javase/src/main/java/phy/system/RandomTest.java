package phy.system;

import java.util.Arrays;
import java.util.Random;

public class RandomTest {
    
    public static void main(String[] args) {
        
        Random r = new Random();
        byte[] buffer = new byte[16];
        //字节数组里随机赋值
        r.nextBytes(buffer);
        System.out.println(Arrays.toString(buffer));
        //生成0.0-1.0之间的随机double数
        System.out.println(r.nextDouble());
        //生成int取值范围内的随机数
        System.out.println(r.nextInt());
        //生成0-100的随机整数
        System.out.println(r.nextInt(100));
    }
}
