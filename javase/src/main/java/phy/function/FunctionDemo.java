package phy.function;

import java.util.function.Function;

/**
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
        myFunction.printName(nameFormat.andThen(s -> "--->" + s));
    }
}
