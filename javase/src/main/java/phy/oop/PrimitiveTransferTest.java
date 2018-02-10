package phy.oop;

public class PrimitiveTransferTest {
   
    public static void swap(int a, int b) {
        
        //交换a,b的值
        int temp = a;
        a = b;
        b = temp;
        System.out.println("swap方法里，a=" + a + ",b=" + b);       
    }
    
    public static void main(String ... args) {
        
        int a = 6;
        int b = 9;
        swap(a, b);
        System.out.println("a=" + a + ",b=" + b);
    }
}
//运行结果，说明值传递是副本传递，本身没有改变
//swap方法里，a=9,b=6
//a=6,b=9
