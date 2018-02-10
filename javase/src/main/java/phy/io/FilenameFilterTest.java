/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package phy.io;

import java.io.File;
import java.io.FilenameFilter;

/**
 *
 * @author Administrator
 */
public class FilenameFilterTest {
    
    public static void main(String[] args) {
        File file = new File(".");
        String[] nameList = file.list(new MyFilenameFilter());
        for(String name : nameList) {
            System.out.println(name);
        }
    }
}    
    
//实现自己的FilenameFilter实现类
class MyFilenameFilter implements FilenameFilter {

    @Override
    public boolean accept(File dir, String name) {
        
        return name.endsWith(".java") || new File(name).isDirectory();
    }  
}
