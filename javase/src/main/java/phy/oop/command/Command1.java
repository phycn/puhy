package phy.oop.command;

public class Command1 implements Command{

    @Override
    public void process(int[] array) {
        
        for(int a : array) {
            
            System.out.println("第一种输出：" + a);
        }
    }    
}
