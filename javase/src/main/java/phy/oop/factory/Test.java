package phy.oop.factory;

public class Test {
    
    public static void main(String[] args) {
        
        OutputFactory of = new OutputFactory();
        Computer c = new Computer(of.getOutput());
        c.keyIn("傻逼");
        c.print();
    }
}
