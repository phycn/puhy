/* 
    运行时调用重写方法时，总是调用的子类的方法
    子类对象赋给父类引用变量时，称为向上转型，总是可以成功的
*/
package phy.oop;

public class SubClassTest extends BaseClass {
   
    //重新定义a,覆盖父类的a
    public String a = "蒲红宇";
    
    @Override
    public void test() {
        System.out.println("子类覆盖父类的方法");
    }
    
    public void sub() {
        System.out.println("子类的普通方法");
    }
    
    public static void main(String ... args) {
        
        //编译时类型和运行时类型一样，不存在多态
        BaseClass bc = new BaseClass();
        //输出6
        System.out.println(bc.a);
        //调用BaseClass的方法
        bc.base();
        bc.test();
        
        //编译时类型和运行时类型一样，不存在多态
        SubClassTest sc = new SubClassTest();
        //输出 蒲红宇
        System.out.println(sc.a);
        //调用自己的test方法
        sc.test();
        //调用从父类继承来的方法
        sc.base();
        
        //编译时类型和运行时类型不一样，多态发生
        BaseClass bc1 = new SubClassTest();
        //输出6，访问的是父类的a
        System.out.println(bc1.a);
        //调用父类的base方法
        bc1.base();
        //调用的是执行当前类的test方法，也就是子类的方法
        bc1.test();
        //下面代码就会编译错误，因为BaseClass类没有sub方法
        //bc1.sub();
    }
}

class BaseClass {
    
    public int a = 6;
    
    public void base() {
        System.out.println("父类的普通方法");
    }
    
    public void test() {
        System.out.println("父类的被覆盖方法");
    }
}
