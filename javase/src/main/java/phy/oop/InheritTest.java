/*
 * 尽量隐藏父类的内部数据
 * 使用final修饰类就不能有子类
 * 不要在父类构造器中调用将要被子类重写的方法
 */
package phy.oop;

public class InheritTest {
    
    public static void main(String [] args) {
        
        Bird a = new Bird();
        a.breath();
        
        Wolf b = new Wolf();
        b.breath();
    }
}

class Animal {
    
    private void beat() {
        System.out.println("1");
    }
    
    public void breath() {
        beat();
        System.out.println("2");
    }
}

class Bird extends Animal{
    
    public void fly() {
        System.out.println("3");
    }
}

class Wolf extends Animal {
    
    public void run() {
        System.out.println("4");
    }
}
