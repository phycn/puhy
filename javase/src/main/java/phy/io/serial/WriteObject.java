/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package phy.io.serial;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 *
 * @author Administrator
 */
public class WriteObject {
    
    public static void main(String ... args) throws IOException {
        
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("E:\\phytest\\object.txt"));
        Person p = new Person("蒲红宇", 24);
        //将p对象写入输出流
        oos.writeObject(p);
        oos.close();
    }
}
