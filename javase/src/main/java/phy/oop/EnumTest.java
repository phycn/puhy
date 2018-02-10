/*
 * 枚举类默认会使用final修饰符，不能派生子类
 * 枚举类的构造器只能使用private修饰符
 * 枚举类的所有实例必须在枚举类的第一行显示列出，默认修饰符为public static final
 */
package phy.oop;

public enum EnumTest {

    SPRING, SUMMER, FALL, WINTER;

    public static void main(String... args) {

        //枚举类都一个value()方法，返回所有枚举值
        for(EnumTest e : EnumTest.values()) {
            
            System.out.println(e);
        }
    }

    public void judge(EnumTest e) {

        //switch语句里的表达式可以是枚举值
        switch (e) {

            case SPRING:
                System.out.println("春天");
                break;
            case SUMMER:
                System.out.println("夏天");
                break;
            case FALL:
                System.out.println("秋天");
                break;
            case WINTER:
                System.out.println("东天");
                break;
        }
    }
}
