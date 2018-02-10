package phy.io.nio;

import java.nio.file.Path;
import java.nio.file.Paths;

public class PathTest {
    
    public static void main(String ... args) {
        
        //以当前路径来创建Path对象
        Path path = Paths.get(".");
        //路径里包含的路径数量
        System.out.println(path.getNameCount());
        //获取根路径
        System.out.println(path.getRoot());
        //获取绝对路径
        Path absolutePath = path.toAbsolutePath();
        System.out.println(absolutePath);
        System.out.println(absolutePath.getRoot());
        System.out.println(absolutePath.getNameCount());
        System.out.println(absolutePath.getName(1));
        
        //以多个路径来构建Path对象， E:\PHY
        Path path1 = Paths.get("E:", "PHY");
        System.out.println(path1);
    }
}
