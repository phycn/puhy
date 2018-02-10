/* 
    final方法修饰的方法不可被重写，不希望子类重写父类的方法，则可以使用final修饰该方法
*/
package phy.oop;

public class FinalMethodTest {
    
    public final void test(){}
}

class sub extends FinalMethodTest {
    
    //编译错误，不能重写final方法
    //public void test(){}
}
