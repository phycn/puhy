package phy.basic;

public class LogicOperatorTest {
    
    public static void main(String ... args) {
    
        int a = 5;
        int b = 10;
        
        //|和||作用相同，但是|不会短路，例如下面会继续运算b++ > 9
        if(a > 6 | b++ > 9) {
        
            System.out.println(a + "---" + b);
        }
        
        //异或^，当两个操作数不同时返回true，相同则返回false
        System.out.println(4 > 5 ^ 3 < 2);
    }
}
