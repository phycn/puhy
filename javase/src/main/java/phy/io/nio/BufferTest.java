package phy.io.nio;

import java.nio.CharBuffer;

public class BufferTest {
    
    public static void main(String ... args) {
        
        //创建容量为8的buffer
        CharBuffer buff = CharBuffer.allocate(8);
        System.out.println("容量："+buff.capacity() + "\n界限："+buff.limit() + "\n位置："+buff.position());
        //放入元素
        buff.put('a');
        buff.put('b');
        buff.put('c');
        //没调用flip方法是读取不到的，有参数get方法可以获取读取到值，例如：get(1)
        System.out.println(buff.get());
        System.out.println("加入三个元素后，位置："+buff.position());
        //将limit设置为position所在位置，并将position设置为0
        buff.flip();
        System.out.println("执行flip方法后，界限："+ buff.limit() + " 位置：" + buff.position());
        //取出第一个元素
        System.out.println(buff.get());
        System.out.println("取出第一个元素后，位置："+buff.position());
        //将position设置为0，将limit设置为capacity
        buff.clear();
        System.out.println("执行clear方法后，界限："+ buff.limit() + " 位置：" + buff.position());
    }
}
