/* 
    负数的二进制为正数的反码加1，例如-5，原码：10000101，反码：11111010，补码：11111011
*/

package phy.basic;

public class BitOperatorTest {
   
    public static void main(String[] args) {
        
        //按位与，都为1为1，不相同为0
        //  00000101
        //& 00001001
        //  00000001
        System.out.println(5 & 9);
        
        //按位或，有一个是1就为1
        //  00000101
        //| 00001001
        //  00001101
        System.out.println(5 | 9);
        
        //按位非
        //  1111 1111 1111 1111 1111 1111 1111 1111 1011  -5
        //  0000 0000 0000 0000 0000 0000 0000 0000 0100   4
        System.out.println(~-5);
        
        //按位异或，相同为0，不相同为1
        //  00000101
        //^ 00001001
        //  00001100
        System.out.println(5 ^ 9);
        
        //左移运算符，将二进制码整体左移，后边空出来的位以0填充
        System.out.println(5 << 2);
        
        //右移，左边空出来的位以原来的符号位填充
        System.out.println(-5 >> 2);
        
        //无符号右移，左边空出来的位总是以0填充
        System.out.println(-5 >>> 2);
        System.out.println(3 % 3);
    }
}
