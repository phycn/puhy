package phy.oop;

//f(0)=1,f(1)=4,f(n+2)=2*f(n+1) + f(n)，求f(10)的值
//递归一定向已知方向递归，不然会成死循环
public class RecursiveTest {
    
    public static int fn(int n) {
    
        if(n == 0) {
            return 1;
        }
        else if(n == 1) {
            return 4;
        }
        //方法内调用自身
        else {
            return 2 * fn(n-1) + fn(n-2);
        }
    }
    
    public static void main(String ... args) {
        
        System.out.println(fn(10));
    }
}
