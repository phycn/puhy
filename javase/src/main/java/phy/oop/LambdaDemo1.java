package phy.oop;

public class LambdaDemo1 {

    public static void main(String[] args) {

        int num = 9;
        //
        Interface1 i1 = () -> 19.12;
        System.out.println(i1.getNum());

        i1 = () -> Math.max(98.81, 71.78);
        System.out.println(i1.getNum());

        Interface2 i2 = (name) -> "哈哈：" + name;
        System.out.println(i2.info("蒲红宇"));

        //块lambda表达式
        i2 = (name) -> {
            //可以使用局部变量，但是不能改变
//            num++;
            String str = "😆";
            return name + str + num;
        };
        System.out.println(i2.info("phy"));

        Interface3<String> i3 = () -> {
          return "这是泛型函数式接口";
        };
    }
}

/**
 * 没有参数的接口
 */
interface Interface1 {
    double getNum();
}

/**
 * 有参数的接口
 */
interface Interface2 {
    String info(String name);
}

/**
 * 泛型接口
 *
 * @param <T>
 */
interface Interface3<T> {
    T hehe();
}
