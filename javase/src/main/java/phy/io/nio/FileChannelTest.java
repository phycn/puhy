package phy.io.nio;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.CharBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;

public class FileChannelTest {
    
    public static void main(String ... args) {
        
        File file = new File("E:\\phytest\\fileChannelTestIn.txt");
        try {
            //创建FileInputStream，以该文件输入流创建FileChannel
            FileChannel inChannel = new FileInputStream(file).getChannel();
            //以文件输出流创建FileChannel，用以控制输出
            FileChannel outChannel = new FileOutputStream("E:\\phytest\\fileChannelTestOut.txt").getChannel();
            //将FileChannel里的全部数据映射成ByteBuffer
            MappedByteBuffer buffer = inChannel.map(FileChannel.MapMode.READ_ONLY, 0, file.length());
            //使用GBK的字符集来创建解码器
            Charset charset = Charset.forName("GBK");
            //直接将buffer里的数据输出，相当于文件拷贝
            outChannel.write(buffer);
            //复原limit和position的位置
            buffer.clear();
            //创建解码器对象
            CharsetDecoder decoder = charset.newDecoder();
            //使用解码器将ByteBuffer对象转换为CharBuffer
            CharBuffer charBuffer = decoder.decode(buffer);
            System.out.println(charBuffer);
            inChannel.close();
            outChannel.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
