package phy.oop.command;

public class Test {
    
    public static void main(String ... args) {
        
        ProcessArray pa = new ProcessArray();
        int[] a = {1,3,5,9};
        //第一次处理数组，具体处理行为取决于Command1
        pa.process(a, new Command1());
        //第二次处理数组，具体处理行为取决于Command2
        pa.process(a, new Command2());
    }
}
