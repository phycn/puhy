package phy.oop.command;

public class Command2 implements Command{

    @Override
    public void process(int[] array) {
        
        for(int a : array) {
            
            System.out.println("第二种输出：" + a);
        }
    }       
}
