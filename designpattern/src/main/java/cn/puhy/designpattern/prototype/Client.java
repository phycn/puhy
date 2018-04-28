package cn.puhy.designpattern.prototype;

/**
 * @author puhongyu
 * 2018/4/23 20:57
 */
public class Client {
    public static void main(String[] args) throws CloneNotSupportedException {
        PrototypeClass p1 = new PrototypeClass();
        //克隆
        PrototypeClass p2 = p1.clone();
        p2.doSometing();
    }
}
