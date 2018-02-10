/*
 * 组合表达的是“有（has-a）”关系，继承表达的是“是（is-a）”关系
 * 
 * 
 */
package phy.oop;

public class CompositeTest {

    public static void main(String[] args) {
        
        //需要显示创建被嵌入对象
        Animal1 a = new Animal1();
        Bird1 b = new Bird1(a);
        b.breath();
    }
}

class Animal1 {

    private void beat() {
        System.out.println("1");
    }

    public void breath() {
        beat();
        System.out.println("2");
    }
}

class Bird1 {
    
    //将原来的父类嵌入原来的子类，作为子类的一个组合部分
    private Animal1 a;
    
    public Bird1(Animal1 a) {
        this.a = a;
    }
    
    //重新定义一个自己的breath方法
    public void breath() {
        //直接复用Animal提供的breath方法来实现Bird的breath方法
        a.breath();
    }
    
    public void fly() {
        System.out.println("3");
    }
} 
