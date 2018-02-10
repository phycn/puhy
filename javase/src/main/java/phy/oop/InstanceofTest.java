/* 
    instanceof运算符前一个操作符通常是一个引用类型变量，后一个通常是一个类或者接口
    用于判断前面的对象是否是后面的类，或者其子类、实现类的实例
*/
package phy.oop;

public class InstanceofTest {
    
    public static void main(String[] args) {
        
        //编译类型为Object，运行类型为String
        Object hello = "Hello";
        //字符串是Object的实例
        System.out.println((hello instanceof Object));
        //字符串是String的实例
        System.out.println((hello instanceof String));
        //Math是Object的子类，可以进行instanceof运算，返回false
        System.out.println((hello instanceof Math));
        
        String a = "phy";
        //下面会编译错误，因为String类型跟Math没有任何关系
        //System.out.println((a instanceof Math));
    }
}
