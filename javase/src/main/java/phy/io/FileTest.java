package phy.io;

import java.io.File;

public class FileTest {
    public static void main(String[] args) {
        //列出磁盘根路径
        File[] roots = File.listRoots();
        for(File root : roots) {
            System.out.println(root);
        }
    }
}
