package phy.function;

import java.util.function.Function;

/**
 * Function<T, R> 输入T输出R的函数
 *
 * @author PUHY
 * 2018-10-07 13:05
 */

class MyFunction {
    private final String name;

    public MyFunction(String name) {
        this.name = name;
    }

    public void printName(Function<String, String> nameFormat) {
        System.out.println("我的名字: " + nameFormat.apply(this.name));
    }
}

public class FunctionDemo {
    public static void main(String[] args) {
        MyFunction myFunction = new MyFunction("蒲红宇");
        Function<String, String> nameFormat = name -> "**" + name + "**";
        //compose为先将参数进行处理下
        myFunction.printName(nameFormat.compose(s -> "[" + s + "]"));
        //andThen为将参数后置处理下
        myFunction.printName(nameFormat.andThen(s -> "--->" + s).andThen(new phy()));

        myFunction.printName(new phy());
    }
}

class phy implements Function<String, String> {
    @Override
    public String apply(String s) {
        return "(" + s + ")";
    }
}
