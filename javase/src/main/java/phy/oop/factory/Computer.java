//让Computer类组合Output对象，与Printer类或者BetterPrinter类完全分离

package phy.oop.factory;

public class Computer {

    private Output out;
    //构造器注入
    public Computer (Output out) {
        this.out = out;
    }

    //定义一个模拟获取字符串输入的方法
    public void keyIn(String msg) {
        out.getData(msg);
    }

    //定义一个模拟打印的方法
    public void print() {
        out.out();
    }
}
