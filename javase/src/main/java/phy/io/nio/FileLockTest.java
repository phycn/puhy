package phy.io.nio;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;

public class FileLockTest {
    
    public static void main(String ... args) throws FileNotFoundException, IOException, InterruptedException {
        
        FileChannel channel = new FileInputStream("a.txt").getChannel();
        //使用非阻塞式方式对指定文件加锁
        FileLock lock = channel.tryLock();
        //10秒内其他程序无法对文件进行修改
        Thread.sleep(10000);
        //释放锁
        lock.release();
    }
}
