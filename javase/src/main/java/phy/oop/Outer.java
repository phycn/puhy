package phy.oop;

public class Outer {
    
    private int out = 10;
    
    //非静态内部类,里面不能有静态方法，静态变量，静态初始化块
    class Inner {
        
        private int in = 6;
        public void accessOut() {
            
            //非静态内部类可以直接访问外部类的成员
            System.out.println(out);
        }
    }
    
    public void accessIn() {
        
        //外部类不能直接访问非静态内部类的实例变量，访问必须显示创建内部类对象
        System.out.println(new Inner().in);
    }
    
    public static void main(String ... args) {
        
        //只是创建了外部类对象，还未创建内部类对象
        Outer o = new Outer();
        o.accessIn();
    }
}
