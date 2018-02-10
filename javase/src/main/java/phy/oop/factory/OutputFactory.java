//工厂类，产生OutPut对象

package phy.oop.factory;

public class OutputFactory {
    
    public Output getOutput() {
        
        return new BetterPrinter();
    }
}
