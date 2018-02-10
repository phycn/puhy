/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package phy.util;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

/**
 *
 * @author Administrator
 */
public class RedirectOut {
    
    public static void out() {
        PrintStream ps = null;
        try {
            ps = new PrintStream(new FileOutputStream("log.txt"));
            System.setOut(ps);
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
        
    }
}
