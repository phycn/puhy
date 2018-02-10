package phy.io.nio;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;

public class CharsetTest {
    
    public static void main(String ... args) throws CharacterCodingException {
        
        //创建简体中文对应的Charset
        Charset cn = Charset.forName("GBK");
        //获取cn对象对应的编码器和解码器
        CharsetEncoder cnEn = cn.newEncoder();
        CharsetDecoder cnDe = cn.newDecoder();
        CharBuffer cb = CharBuffer.allocate(8);
        cb.put('蒲');
        cb.put('红');
        cb.flip();
        //字符序列转换成字节序列
        ByteBuffer bb = cnEn.encode(cb);
        for(int i = 0;i < bb.capacity(); i++) {
            
            System.out.print(bb.get(i) + " ");
        }
        //字节序列解码成字符序列
        System.out.println(cnDe.decode(bb));
    }
}
