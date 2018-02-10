/*
 * 有抽象方法的类只能是抽象类
 * final和abstract不能同时存在，因为final修饰的类不能被继承，修饰的方法不能被重写，而abstarct修饰的类或方法就是要让子类来继承
 * static和abstract不能同时修饰方法，因为static修饰的方法属于类本身，通过类直接调用该方法，如果该方法被定义成了抽象方法，即调用了一个没有方法体的方法，肯定会发生错误。
 * 抽象类体现的是一种模板模式的设计
 */
package phy.oop;

public class AbstractTest {

    public static void main(String ... args) {
        
        //利用多态创建对象
        Shape a = new Triangle("哈哈", 3, 4, 5);
        System.out.println(a.getColor());
        System.out.println(a.calPerimeter());
    }
}

abstract class Shape {

    {
        System.out.println("执行Shape的初始化块");
    }

    private String color;

    //定义一个计算周长的抽象方法
    public abstract double calPerimeter();

    //定义一个返回形状的抽象方法
    public abstract String getType();

    //定义构造器，并不是用于创建对象，而是用于被子类调用
    public Shape() {
    }

    public Shape(String color) {
        System.out.println("执行Shape的构造器");
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}

//定义三角形类
class Triangle extends Shape {
    
    //定义三角形的三边
    private double a;
    private double b;
    private double c;
    
    public Triangle(String color, double a, double b, double c) {
        
        //调用父类构造器
        super(color);
        this.setSides(a, b, c);
    }
    
    private void setSides(double a, double b, double c) {
        
        if(a >= b + c || b >= a + c || c >= a + b) {
            System.out.println("傻逼");
            return;
        }
        this.a = a;
        this.b = b;
        this.c = c;
    }

    @Override
    //重写父类计算周长的方法
    public double calPerimeter() {
        return a + b + c;
    }

    @Override
    //重写父类的返回形状方法
    public String getType() {
        return "三角形";
    }
    
}
