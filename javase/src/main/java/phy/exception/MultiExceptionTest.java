package phy.exception;

public class MultiExceptionTest {
    
    public static void main(String ... args) {
        
        try {
            
        }
        catch(IndexOutOfBoundsException | NumberFormatException e) {
            
            System.out.println("程序发生了数组越界或者格式异常");
            //捕获多异常时，异常变量默认有final修饰，下面会报错
            //e = new IndexOutOfBoundsException("test");
        }
        
        catch(Exception e) {
            //捕获一种类型异常时没有final修饰
            e = new Exception("test");
        }
    }
}
