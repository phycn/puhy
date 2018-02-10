package phy.oop.factory;

public class BetterPrinter implements Output {

    @Override
    public void out() {
        
        System.out.println("哈哈");
    }

    @Override
    public void getData(String msg) {
        
        System.out.println(msg);
    }   
}
