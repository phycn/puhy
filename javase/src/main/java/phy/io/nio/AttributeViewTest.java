package phy.io.nio;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributeView;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileOwnerAttributeView;
import java.nio.file.attribute.UserPrincipal;

public class AttributeViewTest {
    
    public static void main(String[] args) throws IOException {
        
        //获取将要操作的文件
        Path file = Paths.get("E:\\phytest\\testFile.txt");
        //获取访问基本属性的BasicFileAttributeView
        BasicFileAttributeView basicView = Files.getFileAttributeView(file, BasicFileAttributeView.class);
        //获取访问基本属性的BasicFileAttributes
        BasicFileAttributes bfs = basicView.readAttributes();
        //访问文件属性
        System.out.println("创建时间：" + bfs.creationTime());
        
        //获取文件拥有者信息
        FileOwnerAttributeView ownerView = Files.getFileAttributeView(file, FileOwnerAttributeView.class);
        //获取该文件所属的用户
        System.out.println(ownerView.getOwner());
        //获取系统中guest对应的用户
        UserPrincipal user = FileSystems.getDefault().getUserPrincipalLookupService().lookupPrincipalByName("guest");
        //修改用户
        ownerView.setOwner(user);
    }
}
