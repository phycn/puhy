package cn.puhy.designpattern.builder;

/**
 * @author puhongyu
 * 2018/4/18 14:06
 */
public class Client {
    
    public static void main(String[] args) {
        Director director = new Director();
        director.getProductA();
        director.getProductB();
    }
}
