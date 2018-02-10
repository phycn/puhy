/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package phy.basic;

import java.util.Date;

public class PrintfTest {
    public static void main(String[] args) {
        
        double x = 10000.0/3.0;
        //总长度为8，小数位为2
        //System.out.printf("%8.2f", x);
        
        System.out.printf("%tF", new Date());
    }
}
