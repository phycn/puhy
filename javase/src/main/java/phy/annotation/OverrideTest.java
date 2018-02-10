/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package phy.annotation;

/**
 *
 * @author Administrator
 */
public class OverrideTest {
    
    public void info() {
        System.out.println("父类方法");
    }
}

class test1 extends OverrideTest {
    
    //指定下面方法必须重写父类方法
    @Override
    public void info() {
        System.out.println("重写的方法");
    }
}
