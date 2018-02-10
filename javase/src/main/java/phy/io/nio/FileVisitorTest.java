/* 
    FileVisitor代表文件访问器，定义的4个方法
    FileVisitResult postVisitDirectory(T dir, IOException exc):访问子目录之后触发该方法
    FileVisitResult preVisitDirectory(T dir, BasicFileAttributes attrs):访问子目录之前触发该方法
    FileVisitResult visitFile(T file, BasicFileAttributes attrs):访问file文件时触发该方法
    FileVisitResult visitFileFailed(T file, IOException exc):访问file文件失败时触发该方法
*/
package phy.io.nio;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;

public class FileVisitorTest {
    
    public static void main(String ... args) throws Exception {
        
        //遍历目录下所有文件和目录
        Files.walkFileTree(Paths.get("/Users/puhongyu/phy/tmp1"), new SimpleFileVisitor<Path>(){
            
            //访问文件时触发该方法
            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                
                System.out.println("正在访问" + file);
                if(file.endsWith("ojdbc6.jar")) {
                    System.out.println("已经找到文件");
                    //代表中止访问的后续行为
                    //return FileVisitResult.TERMINATE;
                }
                //代表继续访问的后续行为
                return FileVisitResult.CONTINUE;
            }
        });
    }
}
