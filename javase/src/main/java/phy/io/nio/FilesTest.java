package phy.io.nio;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.FileStore;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class FilesTest {
    
    public static void main(String ... args) throws IOException {
        
        Path path = Paths.get("/Users/puhongyu/phy/tmp/test1");
        //复制文件
        Files.copy(path, new FileOutputStream("/Users/puhongyu/phy/tmp/test3"));
        
        //一次性读取文件的所有行
        List<String> lines = Files.readAllLines(path, Charset.forName("GBK"));
        System.out.println(lines);
        //获取文件大小
        System.out.println(Files.size(path));
        
        List<String> poem = new ArrayList<>();
        poem.add("增加的第一行");
        poem.add("增加的第二行");
        //直接将字符串内容写入文件
        Files.write(path, poem, Charset.forName("GBK"));
        
        FileStore store = Files.getFileStore(Paths.get("C:"));
        //C盘总空间
        System.out.println(store.getTotalSpace());
    }
}
